package com.house.service;


import com.github.pagehelper.PageInfo;
import com.house.entity.Street;
import com.house.utils.PageUtil;

import java.util.List;

/**
 * @author 张亮
 * @date 2019-06-26 17:16
 */
public interface StreetService {
    PageInfo<Street> getStreets(PageUtil pageUtil);
    
    PageInfo<Street> getStreets(PageUtil pageUtil, Integer id);
    
    Street getStreet(Integer id);
    
    boolean addStreet(Street street);
    
    boolean updateStreet(Street street);
    
    boolean deleteStreets(Integer[] ids);
    
    boolean deleteStreet(Integer id);
    
    List<Street> getAllStreetById(Integer id);
    
    List<Street> getStreets();
}
