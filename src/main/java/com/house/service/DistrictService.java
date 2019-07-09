package com.house.service;

import com.github.pagehelper.PageInfo;
import com.house.entity.District;
import com.house.utils.PageUtil;

import java.util.List;


/**
 * @author 张亮
 * @date 2019-06-25 18:08
 */
public interface DistrictService {
    PageInfo<District> getDistrictByPage(PageUtil pageUtil);
    
    List<District> getDistricts();
    
    boolean insertDistrict(District district);
    
    boolean updateDistrict(District district);
    
    boolean deleteDistricts(Integer[] ids);
    
    boolean deleteDistrict(Integer id);
    
}
