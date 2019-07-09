package com.house.mapper;

import com.house.entity.House;
import com.house.entity.HouseExample;

import java.util.List;

import com.house.utils.HouseUtils;
import org.apache.ibatis.annotations.Param;

public interface HouseMapper {
    long countByExample(HouseExample example);
    
    int deleteByExample(HouseExample example);
    
    int deleteByPrimaryKey(String id);
    
    int insert(House record);
    
    int insertSelective(House record);
    
    List<House> selectByExample(HouseExample example);
    
    House selectByPrimaryKey(String id);
    
    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);
    
    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);
    
    int updateByPrimaryKeySelective(House record);
    
    int updateByPrimaryKey(House record);
    
    List<House> getHousesByUserId(@Param(value = "userId") Integer userId, @Param(value = "isdel") Integer isdel);
    
    House getDetailHouseById(@Param(value = "id") String id);
    
    House getHouseById(@Param("id") String id);
    
    List<House> getHouseByIsPass(@Param("ispass") Integer ispass);
    
    List<House> getHouses(HouseUtils houseUtils);
    
    
}