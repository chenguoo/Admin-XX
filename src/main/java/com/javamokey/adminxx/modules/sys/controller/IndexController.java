package com.javamokey.adminxx.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明:
 *
 * @author Cheney <br>
 * modified by :
 * @version 1.0 <br>
 * Created in 2017-12-26 17:27
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){


        return "index";
    }
    @RequestMapping("/login")
    public String login(){


        return "login";
    }
}
