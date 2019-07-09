package com.house.utils;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张亮
 * @date 2019-07-05 13:27
 */
public class MapUtils {
    public static Map<String, Object> getMapByPageInfo(PageInfo pageInfo) {
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
}
