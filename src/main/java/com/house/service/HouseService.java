package com.house.service;

import com.github.pagehelper.PageInfo;
import com.house.entity.House;
import com.house.utils.HouseUtils;
import com.house.utils.PageUtil;

import java.util.List;

/**
 * @author 张亮
 * @date 2019-06-26 17:16
 */
public interface HouseService {
    
    PageInfo<House> getHouseByIsPass(PageUtil pageUtil, Integer isPass);
    
    PageInfo<House> getHousesByPage(HouseUtils houseUtils);
    
    boolean checkHouse(String id, Integer ispass);
    
    House getHouse(String id);
    
    boolean addHouse(House house);
    
    boolean updateHouse(House house);
    
    boolean deleteHouse(String id);
    
    PageInfo<House> getHouseByUserId(Integer userId, PageUtil pageUtil);
    
    PageInfo<House> getDeleteHouses(Integer userId, PageUtil pageUtil);
    
    House getHouseById(String id);
    
    House getDetailHouseById(String id);
    
    boolean doRecover(String id);
    
    boolean removeHouse(String id);
    
    boolean removeHouses();
}
