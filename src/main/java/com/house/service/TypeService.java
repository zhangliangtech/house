package com.house.service;


import com.github.pagehelper.PageInfo;
import com.house.entity.Type;
import com.house.utils.PageUtil;

import java.util.List;

/**
 * @author 张亮
 * @date 2019-06-26 17:16
 */
public interface TypeService {
    PageInfo<Type> getTypeByPage(PageUtil pageUtil);
    
    List<Type> getTypes();
    
    Type getType(Integer id);
    
    boolean addType(Type type);
    
    boolean updateType(Type type);
    
    boolean deleteTypes(Integer[] ids);
    
    boolean deleteType(Integer id);
}
