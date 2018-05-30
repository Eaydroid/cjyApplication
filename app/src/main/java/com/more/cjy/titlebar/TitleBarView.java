package com.more.cjy.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.more.cjy.utils.DensityUtil;

/**
 * {自定义TitleBarView}
 * <p>
 * <p>
 * 作者：cjy on 2017/9/26 16:29
 * 邮箱：303592161@qq.com
 */

public class TitleBarView extends ViewGroup implements View.OnClickListener {

    private static final int DEFAULT_ACTION_TEXT_SIZE = 20;
    private static final int DEFAULT_ACTION_TEXT_COLOR = Color.BLACK;
    private static final int DEFAULT_TITLE_BAR_HEIGHT = 48;

    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";

    /**
     * TitleBarView左容器
     */
    private LinearLayout mLeftLayout;
    /**
     * TitleBarView中容器
     */
    private LinearLayout mCenterLayout;
    /**
     * TitleBarView右容器
     */
    private LinearLayout mRightLayout;
    /**
     * TitleBarView下划线
     */
    private View mDividerView;
    /**
     * 是否开启沉浸式支持
     */
    private boolean mImmersive;

    private int mScreenWidth;
    private int mStatusBarHeight;
    private int mActionPadding;
    private int mOutPadding;
    private static int mHeight;

    public TitleBarView(Context context) {
        super(context);
        init(context);
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TitleBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        if (mImmersive) {
            mStatusBarHeight = getStatusBarHeight();
        }
        mActionPadding = dip2px(5);
        mOutPadding = dip2px(5);
        mHeight = dip2px(DEFAULT_TITLE_BAR_HEIGHT);
        initView(context);
    }

    private void initView(Context context) {
        mLeftLayout = new LinearLayout(context);
        mCenterLayout = new LinearLayout(context);
        mRightLayout = new LinearLayout(context);
        mDividerView = new View(context);

        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);

        mLeftLayout.setPadding(0, 0, 0, 0);
        mCenterLayout.setPadding(mOutPadding, 0, mOutPadding, 0);
        mCenterLayout.setGravity(Gravity.CENTER);
        mRightLayout.setPadding(0, 0, 0, 0);

        addView(mLeftLayout, layoutParams);
        addView(mCenterLayout, layoutParams);
        addView(mRightLayout, layoutParams);
        addView(mDividerView, new LayoutParams(LayoutParams.MATCH_PARENT, 1));
//        setDividerColor(R.color.base_title_text);
    }

    public void setImmersive(boolean immersive) {
        mImmersive = immersive;
        if (mImmersive) {
            mStatusBarHeight = getStatusBarHeight();
        } else {
            mStatusBarHeight = 0;
        }
    }

    public void setHeight(int height) {
        mHeight = height;
        setMeasuredDimension(getMeasuredWidth(), mHeight);
    }

    /**
     * 设置下划线drawable
     */
    public void setDivider(Drawable drawable) {
        mDividerView.setBackgroundDrawable(drawable);
    }

    /**
     * 设置下划线色值
     */
    public void setDividerColor(int color) {
        mDividerView.setBackgroundColor(color);
    }

    /**
     * 设置下划线高度
     */
    public void setDividerHeight(int dividerHeight) {
        mDividerView.getLayoutParams().height = dividerHeight;
    }

    @Override
    public void onClick(View view) {
//        if(ClickUtil.isDoubleClick(view.getId())) {
////            MToast.showToast("不能连续点击");
//            return;
//        }
        Action action = (Action) view.getTag();
        action.performAction(view);
    }

    /**
     * 设置title(中间)
     *
     * @param title
     * @return
     */
    public View setTitleText(String title) {
        TextView titleView;
        if (getCenterViewAt(0) != null && getCenterViewAt(0) instanceof TextView) {
            titleView = (TextView) getCenterViewAt(0);
            titleView.setText(title);
        } else {
            if (getCenterViewAt(0) != null) {
                removeCenterActionAt(0);
            }
            titleView = (TextView) addCenterAction(new TextAction(title) {
                @Override
                public void performAction(View view) {

                }
            }
            .setTextSize(20));
        }
        return titleView;
    }

    /**
     * 设置title(中间)
     *
     * @param title
     * @param color
     * @return
     */
    public View setTitleText(String title, int color) {
        TextView titleView;
        if (getCenterViewAt(0) != null && getCenterViewAt(0) instanceof TextView) {
            titleView = (TextView) getCenterViewAt(0);
            titleView.setText(title);
            titleView.setTextColor(color);
        } else {
            if (getCenterViewAt(0) != null) {
                removeCenterActionAt(0);
            }
            titleView = (TextView) addCenterAction(new TextAction(title) {
                @Override
                public void performAction(View view) {

                }
            }.setTextColor(color).setTextSize(20));
        }
        return titleView;
    }

    /**
     * 设置title(中间)
     *
     * @param title
     * @param color
     * @return
     */
    public View setTitleText(String title, int color, int size) {
        TextView titleView;
        if (getCenterViewAt(0) != null && getCenterViewAt(0) instanceof TextView) {
            titleView = (TextView) getCenterViewAt(0);
            titleView.setText(title);
            titleView.setTextColor(color);
            titleView.setTextSize(size);
        } else {
            if (getCenterViewAt(0) != null) {
                removeCenterActionAt(0);
            }
            titleView = (TextView) addCenterAction(new TextAction(title) {
                @Override
                public void performAction(View view) {

                }
            }.setTextColor(color).setTextSize(size));
        }
        return titleView;
    }

    /**
     * 添加右侧图片按钮
     *
     * @param res
     * @param onClickListener
     * @return
     */
    public View addRightImg(int res, final OnClickListener onClickListener) {
        return addRightAction(new ImageAction(res) {
            @Override
            public void performAction(View view) {
                onClickListener.onClick(view);
            }
        });
    }

    /**
     * 添加右侧文字按钮
     *
     * @param text
     * @param onClickListener
     * @return
     */
    public View addRightText(String text, final OnClickListener onClickListener) {
        return addRightAction(new TextAction(text) {
            @Override
            public void performAction(View view) {
                onClickListener.onClick(view);
            }
        }.setTextSize(18));
    }

    /**
     * 添加右侧文字按钮
     *
     * @param text
     * @param onClickListener
     * @return
     */
    public View addRightText(String text, int color, final OnClickListener onClickListener) {
        return addRightAction(new TextAction(text) {
            @Override
            public void performAction(View view) {
                onClickListener.onClick(view);
            }
        }.setTextSize(18).setTextColor(color));
    }

    /**
     * 添加右侧文字按钮
     *
     * @param text
     * @param onClickListener
     * @return
     */
    public View addRightText(String text, int color, int size, final OnClickListener onClickListener) {
        return addRightAction(new TextAction(text) {
            @Override
            public void performAction(View view) {
                onClickListener.onClick(view);
            }
        }.setTextSize(size).setTextColor(color));
    }

    /**
     * 添加左侧图片按钮
     *
     * @param res
     * @param onClickListener
     * @return
     */
    public View addLeftImg(int res, final OnClickListener onClickListener) {
        return addLeftAction(new ImageAction(res) {
            @Override
            public void performAction(View view) {
                onClickListener.onClick(view);
            }
        });
    }

    /**
     * 添加左侧文字按钮
     *
     * @param text
     * @param onClickListener
     * @return
     */
    public View addLeftText(String text, final OnClickListener onClickListener) {
        return addLeftAction(new TextAction(text) {
            @Override
            public void performAction(View view) {
                onClickListener.onClick(view);
            }
        }.setTextSize(18));
    }

    /**
     * 添加右侧文字按钮
     *
     * @param text
     * @param onClickListener
     * @return
     */
    public View addLeftText(String text, int color, final OnClickListener onClickListener) {
        return addLeftAction(new TextAction(text) {
            @Override
            public void performAction(View view) {
                onClickListener.onClick(view);
            }
        }.setTextSize(18).setTextColor(color));
    }

    /**
     * 添加右侧文字按钮
     *
     * @param text
     * @param onClickListener
     * @return
     */
    public View addLeftText(String text, int color, int size, final OnClickListener onClickListener) {
        return addLeftAction(new TextAction(text) {
            @Override
            public void performAction(View view) {
                onClickListener.onClick(view);
            }
        }.setTextSize(size).setTextColor(color));
    }

    /**
     * 添加左容器Action
     */
    public View addLeftAction(Action action) {
        final int index = mLeftLayout.getChildCount();
        return addLeftAction(action, index);
    }

    /**
     * 添加中容器Action
     */
    public View addCenterAction(Action action) {
        final int index = mCenterLayout.getChildCount();
        return addCenterAction(action, index);
    }

    /**
     * 添加右容器Action
     */
    public View addRightAction(Action action) {
        final int index = mRightLayout.getChildCount();
        return addRightAction(action, index);
    }

    /**
     * 添加左容器Action
     */
    private View addLeftAction(Action action, int index) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(action.getWidth(),
                action.getHeight());
        View view = inflateAction(action);
        if(action instanceof TextAction && index == 0) {
            view.setPadding(DensityUtil.dip2px(mRightLayout.getContext(), 15), 0, 0, 0);
        }
        mLeftLayout.addView(view, index, params);
        return view;
    }

    /**
     * 添加中容器Action
     */
    private View addCenterAction(Action action, int index) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(action.getWidth(),
                action.getHeight());
        View view = inflateAction(action);
        mCenterLayout.addView(view, index, params);
        return view;
    }

    /**
     * 添加右容器Action
     */
    private View addRightAction(Action action, int index) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(action.getWidth(),
                action.getHeight());
        View view = inflateAction(action);
        if(action instanceof TextAction) {
            view.setPadding(0, 0, DensityUtil.dip2px(mRightLayout.getContext(), 15), 0);
        }
        mRightLayout.addView(view, index, params);
        return view;
    }

    /**
     * 移除所有Action
     */
    public void removeAllActions() {
        mLeftLayout.removeAllViews();
        mCenterLayout.removeAllViews();
        mRightLayout.removeAllViews();
    }

    public void removeLeftActionAt(int index) {
        mLeftLayout.removeViewAt(index);
    }

    public View getLeftViewAt(int index) {
        return mLeftLayout.getChildAt(index);
    }

    public void removeCenterActionAt(int index) {
        mCenterLayout.removeViewAt(index);
    }

    public View getCenterViewAt(int index) {
        return mCenterLayout.getChildAt(index);
    }

    public void removeRightActionAt(int index) {
        mRightLayout.removeViewAt(index);
    }

    public View getRightViewAt(int index) {
        return mRightLayout.getChildAt(index);
    }

    /**
     * 从容器中移除指定Action
     */
    public void removeAction(Action action) {
        int childCount = mRightLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = mRightLayout.getChildAt(i);
            if (view != null) {
                final Object tag = view.getTag();
                if (tag instanceof Action && tag.equals(action)) {
                    mRightLayout.removeView(view);
                }
            }
        }
        int childCount2 = mLeftLayout.getChildCount();
        for (int i = 0; i < childCount2; i++) {
            View view = mLeftLayout.getChildAt(i);
            if (view != null) {
                final Object tag = view.getTag();
                if (tag instanceof Action && tag.equals(action)) {
                    mLeftLayout.removeView(view);
                }
            }
        }
        int childCount3 = mCenterLayout.getChildCount();
        for (int i = 0; i < childCount3; i++) {
            View view = mCenterLayout.getChildAt(i);
            if (view != null) {
                final Object tag = view.getTag();
                if (tag instanceof Action && tag.equals(action)) {
                    mCenterLayout.removeView(view);
                }
            }
        }
    }

    /**
     * 获取Action总数量
     */
    public int getActionCount() {
        return mRightLayout.getChildCount() + mLeftLayout.getChildCount() + mCenterLayout.getChildCount();
    }

    /**
     * 向容器中注入Action
     */
    private View inflateAction(Action action) {
        View view = action.build(getContext());
        view.setTag(action);
        view.setOnClickListener(this);
        return view;
    }

    /**
     * 通过Action获取制定View
     */
    public View getViewByAction(Action action) {
        View view = findViewWithTag(action);
        return view;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height;
        if (heightMode != MeasureSpec.EXACTLY) {
            height = mHeight + mStatusBarHeight;
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mHeight, MeasureSpec.EXACTLY);
        } else {
            height = MeasureSpec.getSize(heightMeasureSpec) + mStatusBarHeight;
        }
        mScreenWidth = MeasureSpec.getSize(widthMeasureSpec);
        measureChild(mLeftLayout, widthMeasureSpec, heightMeasureSpec);
        measureChild(mRightLayout, widthMeasureSpec, heightMeasureSpec);
        if (mLeftLayout.getMeasuredWidth() > mRightLayout.getMeasuredWidth()) {
            mCenterLayout.measure(
                    MeasureSpec.makeMeasureSpec(mScreenWidth - 2 * mLeftLayout.getMeasuredWidth(), MeasureSpec.EXACTLY)
                    , heightMeasureSpec);
        } else {
            mCenterLayout.measure(
                    MeasureSpec.makeMeasureSpec(mScreenWidth - 2 * mRightLayout.getMeasuredWidth(), MeasureSpec.EXACTLY)
                    , heightMeasureSpec);
        }
        measureChild(mDividerView, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mLeftLayout.layout(0, mStatusBarHeight, mLeftLayout.getMeasuredWidth(),
                mLeftLayout.getMeasuredHeight() + mStatusBarHeight - mDividerView.getMeasuredHeight());
        mRightLayout.layout(mScreenWidth - mRightLayout.getMeasuredWidth(), mStatusBarHeight,
                mScreenWidth, mRightLayout.getMeasuredHeight() + mStatusBarHeight - mDividerView.getMeasuredHeight());
        if (mLeftLayout.getMeasuredWidth() > mRightLayout.getMeasuredWidth()) {
            mCenterLayout.layout(mLeftLayout.getMeasuredWidth(), mStatusBarHeight,
                    mScreenWidth - mLeftLayout.getMeasuredWidth(), getMeasuredHeight() - mDividerView.getMeasuredHeight());
        } else {
            mCenterLayout.layout(mRightLayout.getMeasuredWidth(), mStatusBarHeight,
                    mScreenWidth - mRightLayout.getMeasuredWidth(), getMeasuredHeight() - mDividerView.getMeasuredHeight());
        }
        mDividerView.layout(0, getMeasuredHeight() - mDividerView.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
    }

    public static int dip2px(int dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 计算状态栏高度高度
     * getStatusBarHeight
     *
     * @return
     */
    public static int getStatusBarHeight() {
        return getInternalDimensionSize(Resources.getSystem(), STATUS_BAR_HEIGHT_RES_NAME);
    }

    private static int getInternalDimensionSize(Resources res, String key) {
        int result = 0;
        int resourceId = res.getIdentifier(key, "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
