package com.xht.api.template;

import java.util.Map;

/**
 * Created by xht on 2019/10/22.
 */
public interface IRouteRoot {
    void loadInto(Map<String, Class<? extends IRouteGroup>> routes);
}
