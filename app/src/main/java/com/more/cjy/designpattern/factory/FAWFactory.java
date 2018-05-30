package com.more.cjy.designpattern.factory;

import com.more.cjy.designpattern.factory.car.Car;
import com.more.cjy.designpattern.factory.car.Carola;
import com.more.cjy.designpattern.factory.car.Prado;

/**
 * {一汽汽车生产工厂}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 14:17
 * 邮箱：303592161@qq.com
 */

public class FAWFactory extends CarFactory {
    @Override
    public Car createCar(int modelNo) {
        if(modelNo == Car.CALOLA) {
            return new Carola();
        } else if(modelNo == Car.PRADO) {
            return new Prado();
        }
        return null;
    }
}
