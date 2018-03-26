package com.more.cjy.anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.more.cjy.R;

public class ScaleActivity extends Activity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        iv = (ImageView) findViewById(R.id.iv);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //设置View的PivotX和PivotY则动画相对改点变化，不设置默认已中心点为基准变化
        iv.setPivotX(0);
        iv.setPivotY(0);
        switch (v.getId()) {
            case R.id.btn1:
                iv.animate().scaleX(0.5F);
                break;
            case R.id.btn2:
                iv.animate().scaleXBy(0.5F);
                break;
            case R.id.btn3:
                iv.animate().scaleY(0.5F);
                break;
            case R.id.btn4:
                iv.animate().scaleYBy(0.5F);
                break;
        }
    }
}
