package com.javamokey.adminxx.modules.job.task;

import com.javamokey.adminxx.modules.sys.entity.SysUser;
import com.javamokey.adminxx.modules.sys.service.SysUserService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务(演示Demo，可删除)
 * 
 * testTask为spring bean的名称
 *
 * @author Cheney
 * @since 2018-01-14
 */
@Component("testTask")
public class TestTask {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private SysUserService sysUserService;

	public TestTask(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public void test(String params){
		logger.info("我是带参数的test方法，正在被执行，参数为：" + params);
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SysUser user = sysUserService.selectById(1L);
		System.out.println(ToStringBuilder.reflectionToString(user));
		System.out.println("测试中文乱码问题");
	}
	
	
	public void test2(){
		logger.info("我是不带参数的test2方法，正在被执行");
	}
}
