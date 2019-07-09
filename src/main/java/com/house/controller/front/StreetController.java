package com.house.controller.front;

import com.house.entity.Street;
import com.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 张亮
 * @date 2019-06-25 18:20
 */
@Controller(value = "frontStreetController")
@RequestMapping("/page/")
public class StreetController {
    
    @Autowired
    StreetService streetService;
    
    /**
     * 功能 : 查询所有街道信息
     * 用途 : 发布/修改出租房,查询该区域所属街道
     *
     * @param id 区域ID
     * @return List集合对象
     */
    @RequestMapping(value = "getAllStreetById", method = RequestMethod.POST)
    @ResponseBody
    public List<Street> getAllStreetById(Integer id) {
        return streetService.getAllStreetById(id);
    }
}
