package com.more.cjy.designpattern.factory.car;

import android.util.Log;

/**
 * {大众迈腾}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 14:11
 * 邮箱：cuijingyi@miao.cn
 */

public class Magotan extends Volkswagen {
    public Magotan() {
        setFuelConsumption(8.6f);
        setName("迈腾");
        setPrice(188000);
        setSpeed(6);
    }
    @Override
    public void drive() {
        Log.d("cjy", getBrand() + getName() + "价格："
                + price + ", 油耗：" + fuelConsumption + "(中大型车)");
    }
}
