package com.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.entity.District;
import com.house.entity.Street;
import com.house.entity.StreetExample;
import com.house.mapper.DistrictMapper;
import com.house.mapper.StreetMapper;
import com.house.service.StreetService;
import com.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author 张亮
 * @date 2019-06-26 18:03
 */
@Service
public class StreetServiceImpl implements StreetService {
    
    @Autowired
    private StreetMapper streetMapper;
    @Autowired
    private DistrictMapper districtMapper;
    
    @Override
    public PageInfo<Street> getStreets(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        StreetExample streetExample = new StreetExample();
        List<Street> streets = streetMapper.selectByExample(streetExample);
        for (Street street : streets) {
            District district = districtMapper.selectByPrimaryKey(street.getDistrictId());
            street.setDistrictName(district.getName());
        }
        return new PageInfo<>(streets);
    }
    
    @Override
    public PageInfo<Street> getStreets(PageUtil pageUtil, Integer id) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        List<Street> streets = streetMapper.selectByExample(streetExample);
        return new PageInfo<>(streets);
    }
    
    @Override
    public Street getStreet(Integer id) {
        return streetMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public boolean addStreet(Street street) {
        return streetMapper.insertSelective(street) > 0;
    }
    
    @Override
    public boolean updateStreet(Street street) {
        return streetMapper.updateByPrimaryKey(street) > 0;
    }
    
    @Override
    public boolean deleteStreet(Integer id) {
        return streetMapper.deleteByPrimaryKey(id) > 0;
    }
    
    @Override
    public List<Street> getAllStreetById(Integer id) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        if (id != null && !id.equals("")) {
            criteria.andDistrictIdEqualTo(id);
        }
        return streetMapper.selectByExample(streetExample);
    }
    
    @Override
    public List<Street> getStreets() {
        return streetMapper.selectByExample(null);
    }
    
    @Override
    public boolean deleteStreets(Integer[] ids) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return streetMapper.deleteByExample(streetExample) > 0;
    }
    
}
