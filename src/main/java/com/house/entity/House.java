package com.house.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class House {
    private String id;
    
    private Integer userId;
    
    private String userName;
    
    private Integer typeId;
    
    private String typeName;
    
    private String title;
    
    private String description;
    
    private Long price;
    
    private Date pubdate;
    
    private Integer floorage;
    
    private String contact;
    
    private Integer streetId;
    
    private String streetName;
    
    private Integer ispass;
    
    private String state;
    
    private Integer isdel;
    
    private String path;
    
    private Integer districtId;
    
    private String districtName;
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public Integer getDistrictId() {
        return districtId;
    }
    
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
    
    public String getDistrictName() {
        return districtName;
    }
    
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getTypeId() {
        return typeId;
    }
    
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
    
    public Long getPrice() {
        return price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }
    
    public Date getPubdate() {
        return pubdate;
    }
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }
    
    public Integer getFloorage() {
        return floorage;
    }
    
    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }
    
    public Integer getStreetId() {
        return streetId;
    }
    
    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }
    
    public Integer getIspass() {
        return ispass;
    }
    
    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }
    
    public Integer getIsdel() {
        return isdel;
    }
    
    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getStreetName() {
        return streetName;
    }
    
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public String getTypeName() {
        return typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}