package com.more.cjy.designpattern.factory;

import com.more.cjy.designpattern.factory.car.Car;

/**
 * {此处写描述信息}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 11:34
 * 邮箱：303592161@qq.com
 */

public abstract class CarFactory {
    public abstract Car createCar(int modelNo);

    public final Car createCar(Class <? extends Car> clazz){
        Car car = null;
        try {
            car = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return car;
    }
}
