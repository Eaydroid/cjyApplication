package com.more.cjy.designpattern.factory;

import com.more.cjy.designpattern.factory.car.Car;
import com.more.cjy.designpattern.factory.car.Jetta;
import com.more.cjy.designpattern.factory.car.Magotan;

/**
 * {大众汽车生产工厂}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 14:05
 * 邮箱：cuijingyi@miao.cn
 */

public class VolkswagenFactory extends CarFactory {
    @Override
    public Car createCar(int modelNo) {
        if(modelNo == Car.JETTA) {
            return new Jetta();
        } else if(modelNo == Car.MAGOTAN) {
            return new Magotan();
        }
        return null;
    }
}
