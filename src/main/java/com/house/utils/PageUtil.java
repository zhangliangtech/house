package com.house.utils;

/**
 * @author 张亮
 * @date 2019-06-25 18:13
 */
public class PageUtil {
    //页码
    private Integer page=1;
    //页面数量
    private Integer rows=3;
    
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
}