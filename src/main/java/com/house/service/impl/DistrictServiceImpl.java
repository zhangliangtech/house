package com.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.entity.District;
import com.house.entity.DistrictExample;
import com.house.entity.StreetExample;
import com.house.mapper.DistrictMapper;
import com.house.mapper.StreetMapper;
import com.house.service.DistrictService;
import com.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author 张亮
 * @date 2019-06-25 18:14
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;
    
    @Override
    public PageInfo<District> getDistrictByPage(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        DistrictExample districtExample = new DistrictExample();
        List<District> list = districtMapper.selectByExample(districtExample);
        return new PageInfo<District>(list);
    }
    
    @Override
    public List<District> getDistricts() {
        return districtMapper.selectByExample(null);
    }
    
    
    @Override
    public boolean insertDistrict(District district) {
        return districtMapper.insertSelective(district) > 0;
        
    }
    
    @Override
    public boolean updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district) > 0;
    }
    
    @Override
    public boolean deleteDistricts(Integer[] ids) {
        DistrictExample districtExample = new DistrictExample();
        DistrictExample.Criteria criteria = districtExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return districtMapper.deleteByExample(districtExample) > 0;
    }
    
    /**
     * 事务控制:删除区域,同时删除其子街道
     * @param id 区域id
     * @return
     */
    @Override
    @Transactional
    public boolean deleteDistrict(Integer id) {
        districtMapper.deleteByPrimaryKey(id);
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        streetMapper.deleteByExample(streetExample);
        return true;
    }
}
