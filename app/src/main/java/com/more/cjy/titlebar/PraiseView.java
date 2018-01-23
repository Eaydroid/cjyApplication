package com.more.cjy.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.more.cjy.R;


/**
 * {点赞功能的View}
 * <p>
 * <p>
 * 作者：cjy on 2017/9/22 18:34
 * 邮箱：cuijingyi@miao.cn
 */

public class PraiseView extends RelativeLayout {
    private View parent;
    public ImageView type7_header_praise;
    public TextView type7_praise_no;
    private int praise_num;
    private boolean isPraise;
    private OnClickListener onClickListener;
    public PraiseView(Context context) {
        super(context);
        init(context);
    }

    public PraiseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        parent = li.inflate(R.layout.h5_praise_view, this);

        type7_header_praise = (ImageView) parent.findViewById(R.id.type7_header_praise);
        type7_praise_no = (TextView) parent.findViewById(R.id.type7_praise_no);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(v);
                }
            }
        });
    }

    public int getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(int praise_num) {
        this.praise_num = praise_num;
        type7_praise_no.setText(praise_num + "");
    }

    public boolean isPraise() {
        return isPraise;
    }

    public void setPraise(boolean praise) {
        isPraise = praise;
        if(isPraise) {
            type7_header_praise.setImageResource(R.mipmap.h5_custom_praise);
        } else {
            type7_header_praise.setImageResource(R.mipmap.h5_custom_nonpraise);
        }

    }


}
