package com.more.cjy.titlebar;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * {此处写描述信息}
 * <p>
 * <p>
 * 作者：cjy on 2018/1/23 13:43
 * 邮箱：cuijingyi@miao.cn
 */

public abstract class TextAction extends Action {
    private String mText;
    private int textSize;
    private int textColor;

    public TextAction(String text) {
        mText = text;
    }

    public TextAction setText(String text) {
        mText = text;
        return this;
    }


    public String getText() {
        return mText;
    }

    public TextAction setTextSize(int size) {
        textSize = size;

        return this;
    }

    public int getTextSize() {
        return textSize;
    }

    public TextAction setTextColor(int textColor) {
        this.textColor = textColor;

        return this;
    }

    @Override
    public View build(Context context) {
        TextView text = new TextView(context);
        text.setGravity(Gravity.CENTER);
        String textStr = (getText());
        text.setText(textStr);
        int size = getTextSize();
        text.setTextSize(size > 0 ? size : DEFAULT_ACTION_TEXT_SIZE);
        int textColor = getTextColor();
        text.setTextColor(textColor == 0 ? DEFAULT_ACTION_TEXT_COLOR : textColor);
        text.setSingleLine(true);
        text.setEllipsize(TextUtils.TruncateAt.END);
        text.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10) });
        return text;
    }

    public int getTextColor() {
        return textColor;
    }
}
