package com.more.cjy;

import android.app.Application;

import com.more.cjy.utils.MToast;

/**
 * {此处写描述信息}
 * <p>
 * <p>
 * 作者：cjy on 2018/1/23 16:18
 * 邮箱：cuijingyi@miao.cn
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MToast.init(this);
    }
}
