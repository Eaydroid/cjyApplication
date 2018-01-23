package com.more.cjy.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.more.cjy.R;


/**
 * {H5页面商城Tabview}
 * <p>
 * <p>
 * 作者：cjy on 2017/9/25 10:17
 * 邮箱：cuijingyi@miao.cn
 */

public class MallTabView extends RelativeLayout {

    private OnTabChangeClickListener onTabChangeClickListener;
    private View parent;
    private TextView tv1, tv2;
    private View line1, line2;

    public MallTabView(Context context) {
        super(context);
        init(context);
    }

    public MallTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        parent = li.inflate(R.layout.h5_tab_view, this);
        tv1 = (TextView) parent.findViewById(R.id.tv1);
        tv2 = (TextView) parent.findViewById(R.id.tv2);
        line1 = parent.findViewById(R.id.line1);
        line2 = parent.findViewById(R.id.line2);


        tv1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setState(0);
                if (onTabChangeClickListener != null) {
                    onTabChangeClickListener.onTabChange(v, 0);
                }
            }
        });
        tv2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setState(1);
                if (onTabChangeClickListener != null) {
                    onTabChangeClickListener.onTabChange(v, 1);
                }
            }
        });

    }

    /** 设置商品详情页面的tab状态（tab1和tab2的状态切换） */
    public void setState(int position) {
        if(position == 0) {
            tv1.setTextColor(getResources().getColor(R.color.shop_select));
            line1.setVisibility(View.VISIBLE);
            tv2.setTextColor(getResources().getColor(R.color.black));
            line2.setVisibility(View.GONE);
//            if(webView.getUrl().contains("Tmall/goodsDetailsR.html"))
//                webViewGoBack();
        } else if(position == 1) {
            tv1.setTextColor(getResources().getColor(R.color.black));
            line1.setVisibility(View.GONE);
            tv2.setTextColor(getResources().getColor(R.color.shop_select));
            line2.setVisibility(View.VISIBLE);
//            webView.loadUrl(urls.getGOODSDETAILSR_URL());
        }
    }

    public void setOnTabChangeClickListener(OnTabChangeClickListener listener) {
        onTabChangeClickListener = listener;
    }

    public interface OnTabChangeClickListener {
        void onTabChange(View v, int position);
    }

}
