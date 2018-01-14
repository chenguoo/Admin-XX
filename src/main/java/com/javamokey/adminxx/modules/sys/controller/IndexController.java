package com.javamokey.adminxx.modules.sys.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.javamokey.adminxx.common.annotation.SysLogAnnotation;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.modules.sys.shiro.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
    @Autowired
    private Producer producer;

    @RequestMapping("modules/{module}/{url}.html")
    public String module(@PathVariable("module") String module, @PathVariable("url") String url){
        return "modules/" + module + "/" + url;
    }

    @RequestMapping("{url}.html")
    public String url(@PathVariable("url") String url){
        return url;
    }

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        //其他非系统级的初始化...
        return "index";
    }

    /**
     * 登陆请求
     *
     * @param username
     * @param password
     * @param captcha
     * @return
     */
    @SysLogAnnotation("登陆系统")
    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public R loginPost(String username, String password, String captcha) {
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!captcha.equalsIgnoreCase(kaptcha)) {
            return R.error("验证码不正确");
        }

        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error("账号或密码不正确");
        } catch (LockedAccountException e) {
            return R.error("账号已被锁定,请联系管理员");
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }

        return R.ok();
    }


    /**
     * 退出
     */
    @SysLogAnnotation("退出系统")
    @GetMapping("logout")
    public String logout() {
        ShiroUtils.logout();
        return "redirect:login.html";
    }

    /**
     * 生成验证码
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }


    /**
     * 页面
     *
     * @return
     */
    @GetMapping("main")
    public String main() {
        //init...

        return "main";
    }
}
