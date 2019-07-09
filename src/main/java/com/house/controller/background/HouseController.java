package com.house.controller.background;

import com.github.pagehelper.PageInfo;
import com.house.entity.House;
import com.house.service.HouseService;
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
@Controller(value = "backHouseController")
@RequestMapping("/admin/")
public class HouseController {
    
    @Autowired
    HouseService houseService;
    
    /**
     * 功能 : 查询查出租房
     * 用途 : 审核管理 ,未审核的出租房
     *
     * @param pageUtil 工具类,封装有page,rows
     * @return Map集合对象
     */
    @RequestMapping(value = "getHousesNoPass", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getHousesCheck(PageUtil pageUtil) {
        PageInfo<House> pageInfo = houseService.getHouseByIsPass(pageUtil,0);
        return MapUtils.getMapByPageInfo(pageInfo);
    }
    
    /**
     * 功能 : 查询查出租房
     * 用途 : 审核管理 ,已审核的出租房
     *
     * @param pageUtil 工具类,封装有page,rows
     * @return Map集合对象
     */
    @RequestMapping(value = "getHousesHasPass", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getHousesUnCheck(PageUtil pageUtil) {
        PageInfo<House> pageInfo = houseService.getHouseByIsPass(pageUtil,1);
        return MapUtils.getMapByPageInfo(pageInfo);
    }
    
    /**
     * 功能 : 审核
     * 用途 : 审核管理 , 通过审核
     *
     * @param id 出租房编号
     * @return 响应体:布尔
     */
    @RequestMapping(value = "passHouse", method = RequestMethod.POST)
    @ResponseBody
    public String checkPass(String id) {
        boolean result = houseService.checkHouse(id,1);
        return "{\"result\":" + result + "}";
    }
    
    /**
     * 功能 : 撤销审核
     * 用途 : 审核管理 , 撤销审核
     *
     * @param id 出租房编号
     * @return 响应体:布尔
     */
    @RequestMapping(value = "backPassHouse", method = RequestMethod.POST)
    @ResponseBody
    public String rebackPass(String id) {
        boolean result = houseService.checkHouse(id,0);
        return "{\"result\":" + result + "}";
    }
}
