package com.more.cjy.designpattern.duty;

import android.util.Log;


/**
 * {组长}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/9 11:07
 * 邮箱：303592161@qq.com
 */
public class TeamLeader extends Leader {
    @Override
    public int getLimit() {
        return 5000;
    }

    @Override
    public void handle(int money) {
        Log.d("duty", "TeamLeader审批了报销费用：" + money + "元");
    }
}
