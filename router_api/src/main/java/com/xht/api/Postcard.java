package com.xht.api;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;

import com.xht.annotations.model.RouteMeta;
import com.xht.api.callback.NavigationCallback;

/**
 * Created by xht on 2019/10/23.
 */
public class Postcard extends RouteMeta {

    private Bundle mBundle;         // Data to transform

    //新版风格
    private Bundle optionsCompat;
    private int enterAnim = -1;
    private int exitAnim = -1;

    private int flags = -1;
    private String action;

    private boolean greenChannel;

    public Postcard(String path, String group) {
        this(path, group, null);
    }

    public Postcard(String path, String group, Bundle bundle) {
        setPath(path);
        setGroup(group);
        this.mBundle = (null == bundle ? new Bundle() : bundle);
    }

    public int getEnterAnim() {
        return enterAnim;
    }

    public int getExitAnim() {
        return exitAnim;
    }

    public Postcard withTransition(int enterAnim, int exitAnim) {
        this.enterAnim = enterAnim;
        this.exitAnim = exitAnim;
        return this;
    }

    public Bundle getOptionsBundle() {
        return optionsCompat;
    }


    @RequiresApi(16)
    public Postcard withOptionsCompat(ActivityOptionsCompat compat) {
        if (null != compat) {
            this.optionsCompat = compat.toBundle();
        }
        return this;
    }

    public Bundle getExtras() {
        return mBundle;
    }

    public Postcard withBundle(@Nullable String key, @Nullable Bundle value) {
        mBundle.putBundle(key, value);
        return this;
    }

    public int getFlags() {
        return flags;
    }

    public Postcard addFlags(int flags) {
        this.flags |= flags;
        return this;
    }

    public boolean isGreenChannel() {
        return greenChannel;
    }

    public Postcard greenChannel() {
        this.greenChannel = true;
        return this;
    }

    public String getAction() {
        return action;
    }

    public Postcard withAction(String action) {
        this.action = action;
        return this;
    }


    public Object navigation() {
        return EasyRouter.getInstance().navigation(null, this, -1, null);
    }

    public Object navigation(Context context) {
        return EasyRouter.getInstance().navigation(context, this, -1, null);
    }


    public Object navigation(Context context, NavigationCallback callback) {
        return EasyRouter.getInstance().navigation(context, this, -1, callback);
    }

    public Object navigation(Context context, int requestCode) {
        return EasyRouter.getInstance().navigation(context, this, requestCode, null);
    }

    public Object navigation(Context context, int requestCode, NavigationCallback callback) {
        return EasyRouter.getInstance().navigation(context, this, requestCode, callback);
    }
}
