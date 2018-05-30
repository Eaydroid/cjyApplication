package com.more.cjy.designpattern.singleton;

/**
 * {单例类}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/8 10:18
 * 邮箱：303592161@qq.com
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        //第一重判断，如果已经有instance，可以直接返回不用执行synchronized
        if(instance == null) {
            //假设两个线程A、B同时进入方法体，如果A先执行，则B因为锁在这里等待
            synchronized (Singleton.class) {
                //1.第二重判断，A实例化一个实例后return
                //2.这时候B进来，如果不判空会重新实例一个对象，导致instance不是唯一的，所以再加一层判空
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
