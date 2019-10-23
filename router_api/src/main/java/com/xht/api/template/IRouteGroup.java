package com.xht.api.template;

import com.xht.annotations.model.RouteMeta;

import java.util.Map;

/**
 * Created by xht on 2019/10/22.
 */
public interface IRouteGroup {
    void loadInfo(Map<String, RouteMeta> atlas);
}
