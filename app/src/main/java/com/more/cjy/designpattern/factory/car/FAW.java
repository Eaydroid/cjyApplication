package com.more.cjy.designpattern.factory.car;

/**
 * {一汽汽车的基类}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 13:39
 * 邮箱：303592161@qq.com
 */

public abstract class FAW extends Car {
    @Override
    public void setBrand(String brand) {
        brand = "一汽";
    }
}
