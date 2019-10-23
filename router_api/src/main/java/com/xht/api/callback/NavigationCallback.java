package com.xht.api.callback;

import com.xht.api.Postcard;

/**
 * Created by xht on 2019/10/23.
 */
public interface NavigationCallback {
    /**
     * 找到跳转页面
     *
     * @param postcard
     */
    void onFound(Postcard postcard);

    /**
     * 未找到
     *
     * @param postcard
     */
    void onLost(Postcard postcard);

    /**
     * 成功跳转
     *
     * @param postcard
     */
    void onArrival(Postcard postcard);

    /**
     * 中断了路由跳转
     *
     * @author luoxiaohui
     * @createTime 2019-06-18 17:00
     */
    void onInterrupt(Throwable throwable);
}
