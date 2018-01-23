package com.more.cjy.titlebar;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

/**
 * {View的Action，所有定制化View添加到TitleBarView中需要实现此接口}
 * <p>
 * <p>
 * 作者：cjy on 2018/1/23 13:40
 * 邮箱：cuijingyi@miao.cn
 */
public abstract class Action {
    protected static final int DEFAULT_ACTION_TEXT_SIZE = 20;
    protected static final int DEFAULT_ACTION_TEXT_COLOR = Color.BLACK;
    protected static final int DEFAULT_TITLE_BAR_HEIGHT = 48;

    protected static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";

    abstract public void performAction(View view);

    abstract public View build(Context context);

    public int getHeight() {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    public int getWidth() {
        return ViewGroup.LayoutParams.WRAP_CONTENT;
    }
}
