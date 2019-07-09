package com.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.entity.House;
import com.house.entity.HouseExample;
import com.house.mapper.HouseMapper;
import com.house.service.HouseService;
import com.house.utils.HouseUtils;
import com.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张亮
 * @date 2019-06-28 09:11
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    
    /**
     * 功能 : 查询是否通过审核的房屋
     * 用途 : 后台管理业务
     *
     * @param pageUtil 工具类
     * @param isPass   0或1
     * @return PageInfo
     */
    @Override
    public PageInfo<House> getHouseByIsPass(PageUtil pageUtil, Integer isPass) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        List<House> houses = houseMapper.getHouseByIsPass(isPass);
        return new PageInfo<>(houses);
    }
    
    /**
     * 功能 : 审核功能
     * 用途 : 后台管理业务
     *
     * @param id     出租房Id
     * @param ispass 0或1
     * @return 布尔
     */
    @Override
    public boolean checkHouse(String id, Integer ispass) {
        House house = new House();
        house.setId(id);
        house.setIspass(ispass);
        return houseMapper.updateByPrimaryKeySelective(house) > 0;
    }
    
    /**
     * 功能 : 添加出租房信息
     * 用途 : 前台管理业务
     *
     * @param house 实体类
     * @return 布尔
     */
    @Override
    public boolean addHouse(House house) {
        return houseMapper.insertSelective(house) > 0;
    }
    
    /**
     * 功能 : 更新出租房信息
     * 用途 : 前台管理业务
     *
     * @param house 实体类
     * @return 布尔
     */
    @Override
    public boolean updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house) > 0;
    }
    
    /**
     * 功能 : 逻辑删除
     * 用途 : 前台管理业务
     *
     * @param id 出租房id
     * @return 布尔
     */
    @Override
    public boolean deleteHouse(String id) {
        House house = new House();
        house.setId(id);
        house.setIsdel(1);
        return houseMapper.updateByPrimaryKeySelective(house) > 0;
    }
    
    /**
     * 功能 : 显示该用户的出租房
     * 用途 : 前台管理业务
     *
     * @param userId   用户ID
     * @param pageUtil 工具类
     * @return PageInfo
     */
    @Override
    public PageInfo<House> getHouseByUserId(Integer userId, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        List<House> houseList = houseMapper.getHousesByUserId(userId, 0);
        return new PageInfo<>(houseList, 3);
    }
    
    /**
     * 功能 : 显示该用户删除的出租房
     * 用途 : 前台管理业务
     *
     * @param userId   用户ID
     * @param pageUtil 工具类
     * @return PageInfo
     */
    @Override
    public PageInfo<House> getDeleteHouses(Integer userId, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        List<House> houseList = houseMapper.getHousesByUserId(userId, 1);
        return new PageInfo<>(houseList, 3);
    }
    
    /**
     * 功能 ; 根据ID查询出租房
     * 用途 :前台管理业务 , 修改前的查询
     *
     * @param id 出租房ID
     * @return 实体类
     */
    @Override
    public House getHouseById(String id) {
        return houseMapper.getHouseById(id);
    }
    
    /**
     * 功能 : 通过id查询出租房信息
     * 用途 : 前台管理和展示业务
     *
     * @param id 出租房id
     * @return 布尔
     */
    @Override
    public House getHouse(String id) {
        return houseMapper.selectByPrimaryKey(id);
    }
    
    /**
     * 功能 : 根据ID查询出租房
     * 用途 : 前台管理业务和前台展示业务 , 详细页面展示
     *
     * @param id 出租房ID
     * @return 实体类
     */
    @Override
    public House getDetailHouseById(String id) {
        return houseMapper.getDetailHouseById(id);
    }
    
    @Override
    public boolean doRecover(String id) {
        House house = new House();
        house.setId(id);
        house.setIsdel(0);
        return houseMapper.updateByPrimaryKeySelective(house) > 0;
    }
    
    @Override
    public boolean removeHouse(String id) {
        return houseMapper.deleteByPrimaryKey(id)>0;
    }
    
    @Override
    public boolean removeHouses() {
        HouseExample houseExample = new HouseExample();
        HouseExample.Criteria criteria = houseExample.createCriteria();
        criteria.andIsdelEqualTo(1);
        return houseMapper.deleteByExample(houseExample)>0;
    }
    
    /**
     * 功能 : 查询通过审核并且没有删除的出租房
     * 用途 : 前台展示业务
     *
     * @param houseUtils 查询条件
     * @return PageInfo
     */
    @Override
    public PageInfo<House> getHousesByPage(HouseUtils houseUtils) {
        PageHelper.startPage(houseUtils.getPage(), houseUtils.getRows());
        List<House> houses = houseMapper.getHouses(houseUtils);
        return new PageInfo<>(houses);
    }
    
}
