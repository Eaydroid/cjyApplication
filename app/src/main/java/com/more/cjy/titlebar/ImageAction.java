package com.more.cjy.titlebar;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

/**
 * {此处写描述信息}
 * <p>
 * <p>
 * 作者：cjy on 2018/1/23 13:45
 * 邮箱：cuijingyi@miao.cn
 */

public abstract class ImageAction extends Action {

    private int mDrawable;

    public ImageAction(int drawable) {
        mDrawable = drawable;
    }

    public int getDrawable() {
        return mDrawable;
    }

    public void setDrawable(int mDrawable) {
        this.mDrawable = mDrawable;
    }

    @Override
    public View build(Context context) {
        ImageView img = new ImageView(context);
        img.setImageResource(getDrawable());
        img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return img;
    }
}
