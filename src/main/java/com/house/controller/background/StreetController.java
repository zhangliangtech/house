package com.house.controller.background;

import com.github.pagehelper.PageInfo;
import com.house.entity.Street;
import com.house.service.StreetService;
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
 * @date 2019-06-25 18:20
 */
@Controller
@RequestMapping("/admin/")
public class StreetController {
    
    @Autowired
    StreetService streetService;
    
    /**
     * 功能 : 查询所有街道信息
     * 用途 : 街道管理 ,分页展示
     *
     * @param pageUtil 工具类,封装有page,rows
     * @return 返回集合对象
     */
    @RequestMapping(value = "getStreets", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getStreets(PageUtil pageUtil) {
        PageInfo<Street> pageInfo = streetService.getStreets(pageUtil);
        MapUtils.getMapByPageInfo(pageInfo);
        return MapUtils.getMapByPageInfo(pageInfo);
    }
    
    /**
     * 功能 : 查询所有街道信息
     * 用途 : 区域管理 , 根据区域id查询所属街道 , 分页展示
     *
     * @param pageUtil 工具类
     * @param id       区域编号
     * @return Map集合对象
     */
    @RequestMapping(value = "getStreetsById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getStreetsById(PageUtil pageUtil, Integer id) {
        PageInfo<Street> pageInfo = streetService.getStreets(pageUtil, id);
        return MapUtils.getMapByPageInfo(pageInfo);
    }
    
    /**
     * 功能 : 添加街道
     * 用途 : 街道管理 , 添加街道
     *
     * @param street 实体类接受参数
     * @return 响应体 布尔
     */
    @RequestMapping(value = "addStreet", method = RequestMethod.POST)
    @ResponseBody
    public String addStreet(Street street) {
        boolean result = streetService.addStreet(street);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 : 修改街道
     * 用途 ; 街道管理 , 修改街道
     *
     * @param street 实体类接受参数
     * @return 响应体 布尔
     */
    @RequestMapping(value = "updateStreet", method = RequestMethod.POST)
    @ResponseBody
    public String updateStreet(Street street) {
        boolean result = streetService.updateStreet(street);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 : 单条删除街道
     * 用途 ; 街道管理 , 单条删除
     *
     * @param id 街道编号
     * @return 响应体 . 布尔
     */
    @RequestMapping(value = "deleteStreet", method = RequestMethod.POST)
    @ResponseBody
    public String deleteStreet(Integer id) {
        boolean result = streetService.deleteStreet(id);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 : 批量删除
     * 用途: 街道管理 , 批量删除街道信息
     *
     * @param ids 数组接受id参数
     * @return 响应体 . 布尔
     */
    @RequestMapping(value = "deleteStreets", method = RequestMethod.POST)
    @ResponseBody
    public String deleteStreets(Integer[] ids) {
        boolean result = streetService.deleteStreets(ids);
        return "{\"result\":" + result + "}";
    }
}
