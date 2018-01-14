package com.javamokey.adminxx.modules.job.service.impl;

import com.javamokey.adminxx.modules.job.entity.ScheduleJob;
import com.javamokey.adminxx.modules.job.mapper.ScheduleJobMapper;
import com.javamokey.adminxx.modules.job.service.ScheduleJobService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
