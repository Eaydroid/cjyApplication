package com.more.cjy.designpattern.factory.insurance;

/**
 * {保险的基类}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/16 11:42
 * 邮箱：303592161@qq.com
 */

public abstract class Insurance {
    protected String name;
    protected float price;

    public abstract void desc();
}
