package com.xht.easyrouter;

import android.app.Application;

import com.xht.api.EasyRouter;

/**
 * Created by xht on 2019/10/24.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EasyRouter.init(this);
    }
}
