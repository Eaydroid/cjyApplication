package com.more.cjy.designpattern.factory.car;

import android.util.Log;

/**
 * {丰田普拉多}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 14:14
 * 邮箱：303592161@qq.com
 */

public class Prado extends FAW {
    public Prado() {
        setFuelConsumption(12.6f);
        setName("普拉多");
        setPrice(388000);
        setSpeed(5);
    }
    @Override
    public void drive() {
        Log.d("cjy", getBrand() + getName() + "价格："
                + price + ", 油耗：" + fuelConsumption + "(大型越野车)");
    }
}
