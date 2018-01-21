package com.javamokey.adminxx.modules.gen.controller;


import com.alibaba.fastjson.JSON;
import com.javamokey.adminxx.common.util.PageUtils;
import com.javamokey.adminxx.common.util.Query;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.common.xss.XssHttpServletRequestWrapper;
import com.javamokey.adminxx.modules.gen.service.SysGeneratorService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 */

@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {

	private SysGeneratorService sysGeneratorService;


	public SysGeneratorController(SysGeneratorService sysGeneratorService) {
		this.sysGeneratorService = sysGeneratorService;
	}

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("sys:gen:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<Map<String, Object>> list = sysGeneratorService.queryList(query);
		int total = sysGeneratorService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 生成代码
	 */
	@RequestMapping("/code")
	@RequiresPermissions("sys:gen:code")
	public void code(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//获取表名，不进行xss过滤
		HttpServletRequest orgRequest = XssHttpServletRequestWrapper.getOrgRequest(request);
		String tables = orgRequest.getParameter("tables");

		String[] tableNames = JSON.parseObject(tables, String[].class);


//		String[] tableNames = new Gson().fromJson(tables, String[].class);

		byte[] data = sysGeneratorService.generatorCode(tableNames);
		
		response.reset();  
        response.setHeader("Content-Disposition", "attachment; filename=\"AdminXX.zip\"");
        response.addHeader("Content-Length", "" + data.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");
  
        IOUtils.write(data, response.getOutputStream());
	}


}
