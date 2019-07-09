package com.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.entity.Type;
import com.house.entity.TypeExample;
import com.house.mapper.TypeMapper;
import com.house.service.TypeService;
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
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    
    @Override
    public PageInfo<Type> getTypeByPage(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        List<Type> types = typeMapper.selectByExample(null);
        return new PageInfo<>(types);
    }
    
    @Override
    public List<Type> getTypes() {
        return typeMapper.selectByExample(null);
    }
    
    @Override
    public Type getType(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public boolean addType(Type type) {
        return typeMapper.insertSelective(type) > 0;
    }
    
    @Override
    public boolean updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type) > 0;
    }
    
    @Override
    public boolean deleteTypes(Integer[] ids) {
        TypeExample typeExample = new TypeExample();
        TypeExample.Criteria criteria = typeExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        return typeMapper.deleteByExample(typeExample) > 0;
    }
    
    @Override
    public boolean deleteType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id) > 0;
    }
}
