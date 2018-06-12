package com.more.cjy.designpattern.duty;

import android.util.Log;


/**
 * {技术总监}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/9 11:15
 * 邮箱：303592161@qq.com
 */
public class CTO extends Leader {
    @Override
    public int getLimit() {
        return 20000;
    }

    @Override
    public void handle(int money) {
        Log.d("duty", "CTO审批了报销费用：" + money + "元");
    }
}
