package com.more.cjy.designpattern.factory.car;

import android.util.Log;

/**
 * {捷达汽车}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 13:42
 * 邮箱：cuijingyi@miao.cn
 */

public class Jetta extends Volkswagen {
    public Jetta() {
        setFuelConsumption(6.6f);
        setName("捷达");
        setPrice(88000);
        setSpeed(11);
    }

    @Override
    public void drive() {
        Log.d("cjy", name + "价格：" + price + ", 油耗：" + fuelConsumption);
    }

}
