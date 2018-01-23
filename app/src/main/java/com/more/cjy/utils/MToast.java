package com.more.cjy.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Toast管理类
 */
public class MToast {
    static Toast toast = null;
    private static Context context;

    public static void init(Context context){
        MToast.context = context;
    }

    /**
     * 单一实例Toast
     */
    public static void showNetToast(){
        showToast(context, "亲,网络不给力啊~");
    }

    /**
     * 单一实例Toast
     */
    public static void showToast(String msg){
        MToast.showToast(context, msg);
    }

    /**
     * 单一实例Toast
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void showToast(Context context, String msg) {
        if (toast == null) {
            toast = new Toast(context);
            toast.setDuration(Toast.LENGTH_LONG);

            // 创建字体
            TextView tTitle = new TextView(context);
            tTitle.setText(msg);
            tTitle.setTextSize(15);
            tTitle.setTextColor(Color.parseColor("#ffffffff"));
            tTitle.setGravity(Gravity.CENTER);
            tTitle.setPadding(30, 15, 30, 15);

            // 创建字体容器
            LinearLayout mLinearLayout = new LinearLayout(context);
            GradientDrawable gd = new GradientDrawable();//创建drawable
            gd.setColor(Color.parseColor("#D8737373"));
            gd.setCornerRadius(20);
            mLinearLayout.setBackground(gd);
            mLinearLayout.setOrientation(LinearLayout.VERTICAL);
            mLinearLayout.addView(tTitle);

            toast.setView(mLinearLayout);
        }
        try {
            ((TextView)((ViewGroup)toast.getView()).getChildAt(0)).setText(msg);
        } catch (Throwable e) {
        }
        toast.show();
    }

    public static void showToast(int id) {
        showToast(context, context.getString(id));
    }

    public static void showToast(Context context, int id) {
        showToast(context, context.getString(id));
    }
}

