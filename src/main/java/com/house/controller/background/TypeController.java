package com.house.controller.background;

import com.github.pagehelper.PageInfo;
import com.house.entity.Type;
import com.house.service.TypeService;
import com.house.utils.MapUtils;
import com.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author 张亮
 * @date 2019-06-27 21:56
 */
@Controller
@RequestMapping("/admin/")
public class TypeController {
    @Autowired
    TypeService typeService;
    
    /**
     * 功能 : 查询出租房所有类型
     * 用途 ; 类型管理 , 查询并分页
     *
     * @param pageUtil 工具类,封装有page,rows
     * @return Map集合对象
     */
    @RequestMapping(value = "getTypes", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getTypes(PageUtil pageUtil) {
        PageInfo<Type> pageInfo = typeService.getTypeByPage(pageUtil);
        return MapUtils.getMapByPageInfo(pageInfo);
    }
    
    @RequestMapping(value = "getType", method = RequestMethod.POST)
    @ResponseBody
    public Type getType(Integer id) {
        Type type = typeService.getType(id);
        return type;
    }
    
    /**
     * 功能 : 添加类型
     * 用途 : 类型管理 , 添加出租房类型
     *
     * @param type 实体类接受参数
     * @return 返回true或false字符串--JSON格式
     */
    @RequestMapping(value = "addType", method = RequestMethod.POST)
    @ResponseBody
    public String addType(Type type) {
        boolean result = typeService.addType(type);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 : 修改类型
     * 用途 : 类型管理 , 修改类型
     *
     * @param type 实体类接受参数
     * @return 返回true或false字符串--JSON格式
     */
    @RequestMapping(value = "updateType", method = RequestMethod.POST)
    @ResponseBody
    public String updateType(Type type) {
        boolean result = typeService.updateType(type);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 ; 删除类型
     * 用途 ; 类型管理 , 单条删除
     *
     * @param id 类型编号
     * @return
     */
    @RequestMapping(value = "deleteType", method = RequestMethod.POST)
    @ResponseBody
    public String deleteType(Integer id) {
        boolean result = typeService.deleteType(id);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 ; 删除类型
     * 用途 ; 类型管理 , 批量删除
     *
     * @param ids 数组接受参数
     * @return 返回true或false字符串--JSON格式
     */
    @RequestMapping(value = "deleteTypes", method = RequestMethod.POST)
    @ResponseBody
    public String deleteTypes(Integer[] ids) {
        boolean result = typeService.deleteTypes(ids);
        return "{\"result\":" + result + "}";
    }
}
