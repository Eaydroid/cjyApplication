package com.more.cjy.designpattern.duty;

import android.util.Log;


/**
 * {主管}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/9 11:13
 * 邮箱：303592161@qq.com
 */
public class Director extends Leader {
    @Override
    public int getLimit() {
        return 10000;
    }

    @Override
    public void handle(int money) {
        Log.d("duty", "Director审批了报销费用：" + money + "元");
    }
}
