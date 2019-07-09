package com.house.utils;

/**
 * @author 张亮
 * @date 2019-07-05 21:08
 */
public class HouseUtils {
    
    //页码
    private Integer page = 1;
    //页面数量
    private Integer rows = 5;
    
    private String title;
    
    private String priceRange;
    
    private Integer startPrice;
    
    private Integer endPrice;
    
    private Integer streetId;
    
    private Integer districtId;
    
    private Integer typeId;
    
    private Integer floorage;
    
    
    public Integer getPage() {
        return page;
    }
    
    public void setPage(Integer page) {
        this.page = page;
    }
    
    public Integer getRows() {
        return rows;
    }
    
    public void setRows(Integer rows) {
        this.rows = rows;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getPriceRange() {
        return priceRange;
    }
    
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
        if (this.priceRange != null && !this.priceRange.equals("")) {
            String[] split = priceRange.split("-");
            this.startPrice = Integer.parseInt(split[0]);
            this.endPrice = Integer.parseInt(split[1]);
        }
    }
    
    public Integer getStartPrice() {
        return startPrice;
    }
    
    
    public Integer getEndPrice() {
        return endPrice;
    }
    
    
    public Integer getStreetId() {
        return streetId;
    }
    
    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }
    
    public Integer getTypeId() {
        return typeId;
    }
    
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    
    public Integer getFloorage() {
        return floorage;
    }
    
    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }
    
    public Integer getDistrictId() {
        return districtId;
    }
    
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
}
