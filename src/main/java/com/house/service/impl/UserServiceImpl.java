package com.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.entity.Users;
import com.house.entity.UsersExample;
import com.house.mapper.UsersMapper;
import com.house.service.UserService;
import com.house.utils.MD5Utils;
import com.house.utils.UserCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author 张亮
 * @date 2019-06-28 15:55
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UsersMapper usersMapper;
    
    @Override
    public PageInfo<Users> getUserByPage(UserCondition userCondition, Integer isAdmin) {
        PageHelper.startPage(userCondition.getPage(), userCondition.getRows());
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIsadminEqualTo(isAdmin);
        if (userCondition.getName() != null) {
            criteria.andNameLike("%" + userCondition.getName() + "%");
        }
        if (userCondition.getTelephone() != null) {
            criteria.andTelephoneLike("%" + userCondition.getTelephone() + "%");
        }
        List<Users> users = usersMapper.selectByExample(usersExample);
        return new PageInfo<>(users);
    }
    
    @Override
    public List<Users> getUsers() {
        return usersMapper.selectByExample(null);
    }
    
    
    @Override
    public boolean addUser(Users users) {
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        users.setIsadmin(1);
        return usersMapper.insertSelective(users) > 0;
    }
    
    @Override
    public boolean updateUser(Users users) {
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.updateByPrimaryKeySelective(users) > 0;
    }
    
    @Override
    public boolean deleteUsers(Integer[] ids) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return usersMapper.deleteByExample(usersExample) > 0;
    }
    
    @Override
    public boolean deleteUser(Integer id) {
        return usersMapper.deleteByPrimaryKey(id) > 0;
    }
    
    
    /**
     * 验证用户名重复否
     *
     * @param name 用户名
     * @return 布尔
     */
    @Override
    public boolean chechUser(String name) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andIsadminEqualTo(0);
        List<Users> list = usersMapper.selectByExample(usersExample);
        return list.size() > 0;
    }
    
    /**
     * 注册用户
     *
     * @param users 实体类参数
     * @return 布尔
     */
    @Override
    public boolean registerUser(Users users) {
        users.setIsadmin(0);
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users) > 0;
    }
    
    @Override
    public Users loginUsers(String name, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andIsadminEqualTo(0);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list = usersMapper.selectByExample(usersExample);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }
    
    @Override
    public Users loginAdmin(String name, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andIsadminEqualTo(1);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list = usersMapper.selectByExample(usersExample);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }
    
}
