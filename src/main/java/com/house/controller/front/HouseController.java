package com.house.controller.front;

import com.github.pagehelper.PageInfo;
import com.house.entity.*;
import com.house.service.DistrictService;
import com.house.service.HouseService;
import com.house.service.StreetService;
import com.house.service.TypeService;
import com.house.utils.HouseUtils;
import com.house.utils.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * @author 张亮
 * @date 2019-07-02 09:04
 */
@Controller(value = "frontHouseController")
@RequestMapping("/page/")
public class HouseController {
    
    @Autowired
    private TypeService typeService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private HouseService houseService;
    @Autowired
    StreetService streetService;
    
    /**
     * 功能 : 查询所有出租房信息
     * 用途 : 前往管理页面
     *
     * @param model    作用域
     * @param pageUtil 分页工具类
     * @param session  作用域取登陆信息
     * @return 管理页面
     */
    @RequestMapping(value = "goGuanLi")
    public String goGuanLi(Model model, PageUtil pageUtil, HttpSession session) {
        Users loginInfo = (Users) session.getAttribute("loginInfo");
        PageInfo<House> pageInfo = houseService.getHouseByUserId(loginInfo.getId(), pageUtil);
        model.addAttribute("pageInfo", pageInfo);
        return "/page/guanli";
    }
    
    /**
     * 功能 : 查询所有区域 , 街道 , 出租房类型
     * 用途 : 前往发布页面
     *
     * @param model 作用域
     * @return 发布页面
     */
    @RequestMapping(value = "goFaBu", method = RequestMethod.GET)
    public String goFaBu(Model model) {
        List<Type> types = typeService.getTypes();
        model.addAttribute("types", types);
        List<District> districts = districtService.getDistricts();
        model.addAttribute("districts", districts);
        return "/page/fabu";
    }
    
    /**
     * 功能 : 上传图片
     * 用途 ; 发布 , 修改出租房
     *
     * @param upImage 文件对象
     * @return 响应体 文件名
     * @throws Exception 异常处理
     */
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(MultipartFile upImage) throws Exception {
        //获取图片路径
        String originalFilename = upImage.getOriginalFilename();
        //获取图片格式
        String fileFormat = originalFilename.substring(originalFilename.lastIndexOf("."));
        //根据图片上传时间的毫秒设置文件名
        String fileName = System.currentTimeMillis() + fileFormat;
        //设置文件存储路径
        String filePath = "F:\\nginximg\\" + fileName;
        //存放文件
        File file = new File(filePath);
        upImage.transferTo(file);
        return fileName;
    }
    
    /**
     * 功能 : 添加出租房信息
     * 用途 : 发布出租房
     *
     * @param session 取登陆用户信息
     * @param house   实体类接收参数
     * @return 管理/发布页面,先走控制器查询
     */
    @RequestMapping(value = "faBuHouse", method = RequestMethod.POST)
    public String faBuHouse(HttpSession session, House house) {
        //设置其他隐藏信息
        Users loginInfo = (Users) session.getAttribute("loginInfo");
        house.setUserId(loginInfo.getId());
        house.setIspass(0);
        house.setIsdel(0);
        house.setId(System.currentTimeMillis() + "");
        if (houseService.addHouse(house)) {
            return "redirect:goGuanLi";
        } else {
            return "redirect:/page/goFaBu";
        }
    }
    
    /**
     * 功能 ; 查询所有区域,街道,出租房类型
     * 用途 : 前往修改页面
     *
     * @param id    出租房ID
     * @param model 作用域
     * @return 更新页面
     */
    @RequestMapping(value = "goUpdate", method = RequestMethod.GET)
    public String updateHouse(String id, Model model) {
        //当前出租房信息
        House house = houseService.getHouseById(id);
        model.addAttribute("house", house);
        //所有类型
        List<Type> types = typeService.getTypes();
        model.addAttribute("types", types);
        //所有区域
        List<District> districts = districtService.getDistricts();
        model.addAttribute("districts", districts);
        //所有街道
        List<Street> allStreetById = streetService.getAllStreetById(house.getDistrictId());
        model.addAttribute("allStreetById", allStreetById);
        return "/page/update";
    }
    
    /**
     * 功能 : 查询所有通过审核和未删除的出租房
     * 用途 : 前往展示页面
     *
     * @param model      作用域
     * @param houseUtils 查询条件工具类
     * @return list页面
     */
    @RequestMapping(value = "goList")
    public String goList(Model model, HouseUtils houseUtils) {
        model.addAttribute("houseUtils", houseUtils);
        PageInfo<House> pageInfo = houseService.getHousesByPage(houseUtils);
        model.addAttribute("pageInfo", pageInfo);
        List<District> districts = districtService.getDistricts();
        model.addAttribute("districts", districts);
        if (houseUtils.getDistrictId() != null) {
            List<Street> streets = streetService.getAllStreetById(houseUtils.getDistrictId());
            model.addAttribute("streets", streets);
        }
        List<Type> types = typeService.getTypes();
        model.addAttribute("types", types);
        return "/page/list";
    }
    
    /**
     * 功能 ; 修改出租房信息
     * 用途 ; 修改出租房
     *
     * @param session 作用域取登陆信息
     * @param house   实体类接收参数
     * @return 管理/修改页面,先走控制器
     */
    @RequestMapping(value = "updateHouse", method = RequestMethod.POST)
    public String updateHouse(HttpSession session, House house) {
        Users loginInfo = (Users) session.getAttribute("loginInfo");
        house.setUserId(loginInfo.getId());
        House DbHouse = houseService.getHouse(house.getId());
        house.setIspass(DbHouse.getIspass());
        house.setIsdel(DbHouse.getIsdel());
        if (houseService.updateHouse(house)) {
            return "redirect:goGuanLi";
        } else {
            return "redirect:/page/goUpdate";
        }
    }
    
    /**
     * 功能 ; 查看出租房详情
     * 用途 : 管理页面,展示页面
     *
     * @param id    出租房ID
     * @param model 作用域
     * @return deltalis页面 , 展示详情
     */
    @RequestMapping(value = "detailHouse")
    public String detailHouse(String id, Model model) {
        House house = houseService.getDetailHouseById(id);
        model.addAttribute("house", house);
        return "/page/details";
    }
    
    /**
     * 功能 ; 删除出租房
     * 用途 : 管理页面,逻辑删除
     *
     * @param id 出租房ID
     * @return 管理页面 ,先走控制器
     */
    @RequestMapping(value = "deleteHouse")
    public String detailHouse(String id) {
        houseService.deleteHouse(id);
        return "redirect:goGuanLi";
    }
    
    
    @RequestMapping(value = "goRecycle")
    public String goRecycle(Model model, PageUtil pageUtil, HttpSession session) {
        Users loginInfo = (Users) session.getAttribute("loginInfo");
        PageInfo<House> pageInfo = houseService.getDeleteHouses(loginInfo.getId(), pageUtil);
        model.addAttribute("pageInfo", pageInfo);
        return "/page/recycle";
    }
    
    /**
     * 功能 ; 恢复出租房
     * 用途 : 回收站页面,恢复被删除的记录
     *
     * @param id 出租房ID
     * @return 回收站页面 ,先走控制器
     */
    @RequestMapping(value = "doRecover")
    public String doRecover(String id) {
        houseService.doRecover(id);
        return "redirect:goRecycle";
    }
    
    /**
     * 功能 ; 彻底删除出租房
     * 用途 : 回收站页面,彻底删除
     *
     * @param id 出租房ID
     * @return 回收站页面 ,先走控制器
     */
    @RequestMapping(value = "removeHouse")
    public String removeHouse(String id) {
        houseService.removeHouse(id);
        return "redirect:goRecycle";
    }
    
    /**
     * 功能 ; 删除用户所有出租房
     * 用途 : 回收站页面,清空回收站
     *
     * @return 回收站页面 ,先走控制器
     */
    @RequestMapping(value = "removeHouses")
    public String removeHouses() {
        houseService.removeHouses();
        return "redirect:goRecycle";
    }
    
    
}
