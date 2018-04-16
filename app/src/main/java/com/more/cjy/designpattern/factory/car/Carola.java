package com.more.cjy.designpattern.factory.car;

import android.util.Log;

/**
 * {一汽丰田卡罗拉}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 13:58
 * 邮箱：cuijingyi@miao.cn
 */

public class Carola extends FAW {
    public Carola() {
        setName("卡罗拉");
        setPrice(10.8f);
        setSpeed(7);
        setFuelConsumption(6.6f);
    }

    @Override
    public void drive() {
        Log.d("cjy", name + "价格：" + getPrice() + "万");
    }
}
