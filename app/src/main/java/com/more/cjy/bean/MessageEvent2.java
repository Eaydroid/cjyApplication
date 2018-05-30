package com.more.cjy.bean;

/**
 * {此处写描述信息}
 * <p>
 * <p>
 * 作者：cjy on 2018/5/30 15:04
 * 邮箱：303592161@qq.com
 */

public class MessageEvent2 {
    public String name;
    public String password;

    public MessageEvent2(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
