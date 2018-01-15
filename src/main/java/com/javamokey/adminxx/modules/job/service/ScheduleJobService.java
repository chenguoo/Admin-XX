package com.javamokey.adminxx.modules.job.service;

import com.javamokey.adminxx.modules.job.entity.ScheduleJob;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 定时任务 服务类
 * </p>
 *
 * @author Cheney
 * @since 2018-01-14
 */
public interface ScheduleJobService extends IService<ScheduleJob> {

    /**
     * 批量删除定时任务
     */
    void deleteBatch(Long[] jobIds);

    /**
     * 暂停运行
     */
    void pause(Long[] jobIds);

    /**
     * 恢复运行
     */
    void resume(Long[] jobIds);

    /**
     * 立即执行
     */
    void run(Long[] jobIds);
}
