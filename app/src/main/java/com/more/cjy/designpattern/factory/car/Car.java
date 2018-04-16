package com.more.cjy.designpattern.factory.car;

import com.more.cjy.designpattern.factory.insurance.Insurance;

/**
 * {小轿车基类}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 11:37
 * 邮箱：cuijingyi@miao.cn
 */

public abstract class Car {
    public static final int JETTA = 1;
    public static final int MAGOTAN = 2;
    public static final int CALOLA = 3;
    public static final int PRADO = 4;
    public String name;
    public String brand;
    public float price;
    public int speed;
    /** 油耗 */
    public float fuelConsumption;
    private Insurance insurance;

    public abstract void drive();

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", speed=" + speed +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
