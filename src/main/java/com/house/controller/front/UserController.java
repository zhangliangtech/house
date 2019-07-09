package com.house.controller.front;

import com.house.entity.Users;
import com.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 张亮
 * @date 2019-07-01 16:17
 */
@Controller(value = "frontUserController")
@RequestMapping("/page/")
public class UserController {
    @Autowired
    UserService userService;
    
    /**
     * 功能 : 注册用户名校验
     * 用途 : 注册页面
     *
     * @param name 用户名
     * @return 布尔
     */
    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    @ResponseBody
    public String checkUser(String name) {
        return "{\"result\":" + userService.chechUser(name) + "}";
    }
    
    /**
     * 功能 : 注册用户名
     *
     * @param users 实体接收参数
     * @param model 作用域
     * @return 登陆/注册页面
     */
    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    public String registerUser(Users users, Model model) {
        if (userService.registerUser(users)) {
            model.addAttribute("registerInfo", "注册成功！");
            return "/page/login";
        } else {
            model.addAttribute("registerInfo", "注册失败！");
            return "/page/regs";
        }
    }
    
    /**
     * 功能 : 登陆用户
     * 用途 ; 登陆页面
     *
     * @param name     用户名
     * @param password 密码
     * @param session  作用域
     * @param model    作用域
     * @return 登陆或管理页面
     */
    @RequestMapping(value = "loginUser", method = RequestMethod.POST)
    public String loginUser(String name, String password, HttpSession session, Model model) {
        Users users = userService.loginUsers(name, password);
        if (users == null) {
            model.addAttribute("registerInfo", "用户名或密码错误，登录失败！");
            return "/page/login";
        } else {
            session.setAttribute("loginInfo", users);
            return "redirect:goGuanLi";
        }
    }
    /**
     * 功能 : 退出登陆
     * 用途 : 前台页面
     *
     * @param session 作用域
     * @return 登陆页面
     */
    @RequestMapping(value = "logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginInfo");
        return "/page/login";
    }
}
