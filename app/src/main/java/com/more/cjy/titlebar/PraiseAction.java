package com.more.cjy.titlebar;

import android.content.Context;
import android.view.View;

/**
 * {点赞自定义Action}
 * <p>
 * <p>
 * 作者：cjy on 2017/10/12 11:03
 * 邮箱：cuijingyi@miao.cn
 */

public abstract class PraiseAction extends Action {
    private int mDrawable;

    @Override
    public void performAction(View view) {

    }

    public int getDrawable() {
        return mDrawable;
    }

    @Override
    public View build(Context context) {
        return new PraiseView(context);
    }
}
