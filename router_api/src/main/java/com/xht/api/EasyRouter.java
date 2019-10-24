package com.xht.api;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.xht.api.template.IRouteGroup;
import com.xht.api.template.IRouteRoot;
import com.xht.api.utils.ClassUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

/**
 * Created by xht on 2019/10/23.
 */
public class EasyRouter {

    private static final String TAG = "EasyRouter";
    private static final String ROUTE_ROOT_PAKCAGE = "com.xht.easyrouter.routes";
    private static final String SDK_NAME = "EaseRouter";
    private static final String SEPARATOR = "_";
    private static final String SUFFIX_ROOT = "Root";

    private static EasyRouter sInstance;
    private static Application mContext;
    private Handler mHandler;

    private EasyRouter() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static EasyRouter getInstance() {
        if (sInstance == null) {
            synchronized (EasyRouter.class) {
                if (sInstance == null) {
                    sInstance = new EasyRouter();
                }
            }
        }
        return sInstance;
    }


    public static void init(Application application) {
        mContext = application;
        try {
            loadInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadInfo() throws PackageManager.NameNotFoundException, InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获得所有 apt生成的路由类的全类名 (路由表)
        Set<String> routerMap = ClassUtils.getFileNameByPackageName(mContext, ROUTE_ROOT_PAKCAGE);
        for (String className : routerMap) {
            if (className.startsWith(ROUTE_ROOT_PAKCAGE + "." + SDK_NAME + SEPARATOR + SUFFIX_ROOT)) {
                ((IRouteRoot) Class.forName(className).getConstructor().newInstance()).loadInfo(Warehouse.groupsIndex);
            }
        }

        for (Map.Entry<String, Class<? extends IRouteGroup>> stringClassEntry : Warehouse.groupsIndex.entrySet()) {
            Log.d(TAG, "Root映射表[ " + stringClassEntry.getKey() + " : " + stringClassEntry.getValue() + "]");
        }

    }
}
