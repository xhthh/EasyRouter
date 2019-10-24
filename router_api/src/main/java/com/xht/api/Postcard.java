package com.xht.api;

import android.os.Bundle;

import com.xht.annotations.model.RouteMeta;

/**
 * Created by xht on 2019/10/23.
 */
public class Postcard extends RouteMeta {

    public Postcard(String path, String group) {
        this(path, group, null);
    }

    public Postcard(String path, String group, Bundle bundle) {
        setPath(path);
        setGroup(group);
    }

}
