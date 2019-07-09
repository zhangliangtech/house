package com.house.controller.background;

import com.github.pagehelper.PageInfo;
import com.house.entity.District;
import com.house.service.DistrictService;
import com.house.utils.MapUtils;
import com.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author 张亮
 * @date 2019-06-25 18:20
 */
@Controller
@RequestMapping("/admin/")
public class DistrictController {
    
    @Autowired
    DistrictService districtService;
    
    /**
     * 功能 : 查询所有区域信息
     * 用途 : 区域管理分页
     *
     * @param pageUtil 工具类,封装有page,rows
     * @return Map区域集合
     */
    @RequestMapping(value = "getDistricts", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getDistricts(PageUtil pageUtil) {
        PageInfo<District> pageInfo = districtService.getDistrictByPage(pageUtil);
        return MapUtils.getMapByPageInfo(pageInfo);
    }
    
    /**
     * 功能 : 添加区域
     * 用途 : 添加区域
     *
     * @param district 实体类接受参数
     * @return 返回true或false字符串--JSON格式
     */
    @RequestMapping(value = "addDistrict", method = RequestMethod.POST)
    @ResponseBody
    public String addDistrict(District district) {
        boolean result = districtService.insertDistrict(district);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 : 修改区域
     * 用途 : 区域管理修改区域
     *
     * @param district 实体类接受参数
     * @return 返回true或false字符串--JSON格式
     */
    @RequestMapping(value = "updateDistrict", method = RequestMethod.POST)
    @ResponseBody
    public String updateDistrict(District district) {
        boolean result = districtService.updateDistrict(district);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 : 删除区域 单条
     * 用途 : 区域管理,单条删除区域
     *
     * @param id
     * @return 返回true或false字符串--JSON格式
     */
    @RequestMapping(value = "deleteDistrict", method = RequestMethod.POST)
    @ResponseBody
    public String deleteDistrict(Integer id) {
        
        try {
            districtService.deleteDistrict(id);
            return "{\"result\":true}";
        } catch (Exception e) {
        }
        return "{\"result\":false}";
    }
    
    /**
     * 功能 : 删除区域 批量
     * 用途 : 区域管理,批量删除区域
     *
     * @param ids 数组接受id参数
     * @return 返回true或false字符串--JSON格式
     */
    @RequestMapping(value = "deleteDistricts", method = RequestMethod.POST)
    @ResponseBody
    public String deleteDistricts(Integer[] ids) {
        boolean result = districtService.deleteDistricts(ids);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 : 查询所有区域信息
     * 用途 : 街道管理 添加街道时,下拉列表选择区域
     *
     * @return List区域集合
     */
    @RequestMapping(value = "getDistrictList", method = RequestMethod.POST)
    @ResponseBody
    public List<District> getDistricts() {
        List<District> districts = districtService.getDistricts();
        return districts;
    }
}
