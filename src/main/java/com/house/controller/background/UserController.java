package com.house.controller.background;

import com.github.pagehelper.PageInfo;
import com.house.entity.Users;
import com.house.service.UserService;
import com.house.utils.MapUtils;
import com.house.utils.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 张亮
 * @date 2019-06-28 17:17
 */
@Controller(value = "backUserController")
@RequestMapping("/admin/")
public class UserController {
    
    @Autowired
    UserService userService;
    
    /**
     * 功能 : 管理员登陆
     * 用途 ; 管理员登陆页面 , 传入用户名密码 , 验证
     *
     * @param name     用户名
     * @param password 密码
     * @param session  登陆成功,存放管理员信息
     * @param model    存放登陆成功或失败的提示信息
     * @return 管理员登陆页面 , 后台管理页面
     */
    @RequestMapping(value = "loginAdmin", method = RequestMethod.POST)
    public String loginAdmin(String name, String password, HttpSession session, Model model) {
        Users users = userService.loginAdmin(name, password);
        if (users == null) {
            model.addAttribute("AdminLoginInfo", "用户名或密码错误，登录失败！");
            return "/admin/login";
        } else {
            session.setAttribute("adminInfo", users);
            return "/admin/admin";
        }
    }
    
    /**
     * 功能 : 修改登陆密码
     * @param password 密码
     * @param session 登陆信息
     * @return 修改的密码
     */
    @RequestMapping(value = "changePassword")
    @ResponseBody
    public String changePassword(String password, HttpSession session) {
        Users users = (Users) session.getAttribute("adminInfo");
        users.setPassword(password);
        userService.updateUser(users);
        return password;
    }
    
    /**
     * 功能 : 查询管理员
     * 用途 : 用户管理 , 管理员分页显示 , 条件查询
     *
     * @param userCondition 查询条件工具类
     * @return Map集合
     */
    @RequestMapping(value = "getAdminUsers", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getAdminUsers(UserCondition userCondition) {
        PageInfo<Users> pageInfo = userService.getUserByPage(userCondition, 1);
        return MapUtils.getMapByPageInfo(pageInfo);
    }
    
    /**
     * 功能 ; 查询普通用户
     * 用途 : 用户管理 ,管理员分页显示 , 条件查询
     *
     * @param userCondition 查询条件工具类
     * @return Map集合
     */
    @RequestMapping(value = "getUsers", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getUsers(UserCondition userCondition) {
        PageInfo<Users> pageInfo = userService.getUserByPage(userCondition, 0);
        return MapUtils.getMapByPageInfo(pageInfo);
    }
    
    /**
     * 功能 ; 添加管理员
     * 用途 ; 用户管理 , 添加管理员
     *
     * @param user 实体类接收参数
     * @return 响应体 布尔
     */
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(Users user) {
        boolean result = userService.addUser(user);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 ; 修改管理员
     * 用途 ; 用户管理 , 修改管理员
     *
     * @param user 实体类接收参数
     * @return 响应体 布尔
     */
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(Users user) {
        boolean result = userService.updateUser(user);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 ; 删除管理员
     * 用途 ; 用户管理 , 单条删除管理员
     *
     * @param id 管理员Id
     * @return 响应体 布尔
     */
    @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public String deleteUser(Integer id) {
        return "{\"result\":" + userService.deleteUser(id) + "}";
    }
    
    /**
     * 功能 ; 删除管理员
     * 用途 : 用户管理 , 批量删除管理员
     *
     * @param ids 数组接收管理员ids
     * @return 响应体 布尔
     */
    @RequestMapping(value = "deleteUsers", method = RequestMethod.POST)
    @ResponseBody
    public String deleteUsers(Integer[] ids) {
        boolean result = userService.deleteUsers(ids);
        return "{\"result\":" + result + "}";
    }
}
