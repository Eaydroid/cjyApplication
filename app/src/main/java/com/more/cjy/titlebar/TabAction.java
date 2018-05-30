package com.more.cjy.titlebar;

import android.content.Context;
import android.view.View;

/**
 * {商城自定义tab Action}
 * <p>
 * <p>
 * 作者：cjy on 2017/10/12 10:52
 * 邮箱：303592161@qq.com
 */

public abstract class TabAction extends Action implements MallTabView.OnTabChangeClickListener {
    private int color;
    private MallTabView.OnTabChangeClickListener listener;

    public TabAction() {
    }

    public TabAction setColor(int color) {
        this.color = color;
        return  this;
    }

    public int getTextColor() {
        return color;
    }

    @Override
    public void performAction(View view) {

    }

    @Override
    public View build(Context context) {
        MallTabView tab = new MallTabView(context);
        tab.setOnTabChangeClickListener(this);
        return tab;
    }

}
