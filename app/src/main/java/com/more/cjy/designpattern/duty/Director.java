package com.more.cjy.designpattern.duty;

import android.util.Log;

import com.more.cjy.utils.MToast;

/**
 * {主管}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/9 11:13
 * 邮箱：cuijingyi@miao.cn
 */
public class Director extends Leader {
    @Override
    public int getLimit() {
        return 10000;
    }

    @Override
    public void handle(int money) {
        Log.d("duty", "Director审批了报销费用：" + money + "元");
        MToast.showToast("Director审批了报销费用：" + money + "元");
    }
}
