package com.more.cjy.designpattern.factory.insurance;

import android.util.Log;

/**
 * {人寿保险}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 13:31
 * 邮箱：cuijingyi@miao.cn
 */

public class RenShouInsurance extends Insurance {
    public RenShouInsurance() {
        name = "人寿保险";
        price = 3000;
    }
    @Override
    public void desc() {
        Log.d("cjy", "我们是" + name + " ,价格是" + price + "元/年");
    }
}
