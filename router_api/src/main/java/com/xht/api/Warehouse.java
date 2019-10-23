package com.xht.api;

import com.xht.annotations.model.RouteMeta;
import com.xht.api.template.IRouteGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xht on 2019/10/23.
 */
public class Warehouse {

    // root 映射表 保存分组信息
    static Map<String, Class<? extends IRouteGroup>> groupsIndex = new HashMap<>();

    // group 映射表 保存组中的所有数据
    static Map<String, RouteMeta> routes = new HashMap<>();

}
