package com.more.cjy.designpattern.factory.insurance;

import android.util.Log;

/**
 * {平安保险}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 13:34
 * 邮箱：303592161@qq.com
 */

public class PingAnInsurance extends Insurance {
    public PingAnInsurance() {
        name = "平安保险";
        price = 2500;
    }
    @Override
    public void desc() {
        Log.d("cjy", "我们是" + name + " ,价格是" + price + "元/年");
    }
}
