package com.javamokey.adminxx.modules.job.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.javamokey.adminxx.common.util.Constant;
import com.javamokey.adminxx.modules.job.entity.ScheduleJob;
import com.javamokey.adminxx.modules.job.mapper.ScheduleJobMapper;
import com.javamokey.adminxx.modules.job.service.ScheduleJobService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.javamokey.adminxx.modules.job.util.ScheduleUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 定时任务 服务实现类
 * </p>
 *
 * @author Cheney123
 * @since 2018-01-14
 */
@Service
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobMapper, ScheduleJob> implements ScheduleJobService {
    private Scheduler scheduler;
    private ScheduleJobMapper scheduleJobMapper;

    public ScheduleJobServiceImpl(Scheduler scheduler, ScheduleJobMapper scheduleJobMapper) {
        this.scheduler = scheduler;
        this.scheduleJobMapper = scheduleJobMapper;
    }

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() {
        List<ScheduleJob> scheduleJobList = scheduleJobMapper.selectList(null);
        for (ScheduleJob scheduleJob : scheduleJobList) {
            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobId());
            //如果不存在，则创建
            if (cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
            } else {
                ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
            }
        }
    }

    @Override
    public void deleteBatch(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.deleteScheduleJob(scheduler, jobId);
        }
        ArrayList<Long> ids = new ArrayList<>(Arrays.asList(jobIds));
        //删除数据
        scheduleJobMapper.deleteBatchIds(ids);
    }

    @Override
    @Transactional
    public void pause(Long[] jobIds) {
        ArrayList<ScheduleJob> scheduleJobs = new ArrayList<>();
        for(Long jobId : jobIds){
            ScheduleUtils.pauseJob(scheduler, jobId);

            ScheduleJob job = new ScheduleJob();
            job.setJobId(jobId);
            job.setStatus(Constant.ScheduleStatus.PAUSE.getValue());
            scheduleJobs.add(job);
        }
        updateBatchById(scheduleJobs);
    }

    @Override
    @Transactional
    public void resume(Long[] jobIds) {
        ArrayList<ScheduleJob> scheduleJobs = new ArrayList<>();

        for(Long jobId : jobIds){
            ScheduleUtils.resumeJob(scheduler, jobId);

            ScheduleJob job = new ScheduleJob();
            job.setJobId(jobId);
            job.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
            scheduleJobs.add(job);
        }

        updateBatchById(scheduleJobs);
    }

    @Override
    @Transactional
    public void run(Long[] jobIds) {
        for(Long jobId : jobIds){
            ScheduleUtils.run(scheduler, selectById(jobId));
        }
    }
}
