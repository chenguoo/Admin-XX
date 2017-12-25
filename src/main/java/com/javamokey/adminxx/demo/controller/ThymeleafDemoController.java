package com.javamokey.adminxx.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明:
 *
 * @author Cheney <br>
 * modified by :
 * @version 1.0 <br>
 * Created in 2017-12-25 10:41
 */
@Controller
@RequestMapping("/demo")
public class ThymeleafDemoController {

    @RequestMapping("/thymeleafDemo")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://www.javamokey.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "demo/thymeleafDemo";
    }
}
