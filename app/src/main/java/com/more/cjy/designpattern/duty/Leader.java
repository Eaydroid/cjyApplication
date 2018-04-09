package com.more.cjy.designpattern.duty;

import android.util.Log;

import com.more.cjy.utils.MToast;

/**
 * {领导的抽象类}
 * <p>
 * <p>
 * 作者：cjy on 2018/4/9 11:01
 * 邮箱：cuijingyi@miao.cn
 */
public abstract class Leader {
    /** 上级领导 */
    protected Leader higherLeader;
    public final void handleRequest(int money) {
        if(money <= getLimit()) { //自己审批事件
            handle(money);
        } else { //超出自己的能力，需要交给上级领导审批
            Log.d("duty", getClass().getSimpleName() + "无法审批" + money + "元报销，递交上级领导审批");
            if(higherLeader != null) {
                higherLeader.handleRequest(money);
            } else {
                Log.d("duty", "报销" + money + "元，没有上级领导能审批这次报销");
                MToast.showToast("没有领导能审批报销费用：" + money + "元，无情拒绝");
            }
        }
    }
    public abstract int getLimit();
    public abstract void handle(int money);
}
