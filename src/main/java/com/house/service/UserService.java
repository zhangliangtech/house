package com.house.service;


import com.github.pagehelper.PageInfo;
import com.house.entity.Users;
import com.house.utils.UserCondition;

import java.util.List;

/**
 * @author 张亮
 * @date 2019-06-26 17:16
 */
public interface UserService {
    
    PageInfo<Users> getUserByPage(UserCondition userCondition, Integer isAdmin);
    
    List<Users> getUsers();
    
    boolean addUser(Users users);
    
    boolean updateUser(Users users);
    
    boolean deleteUsers(Integer[] ids);
    
    boolean deleteUser(Integer id);
    
    boolean chechUser(String name);
    
    boolean registerUser(Users users);
    
    Users loginUsers(String name, String password);
    
    Users loginAdmin(String name, String password);
}
