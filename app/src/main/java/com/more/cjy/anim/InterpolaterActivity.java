package com.more.cjy.anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.more.cjy.R;

public class InterpolaterActivity extends Activity implements View.OnClickListener {

    private ImageView iv;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolater);

        iv = (ImageView) findViewById(R.id.iv);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                //先加速再减速。这是默认的Interpolator，如果不设置的话，动画默认使用这个Interpolator。
                iv.animate().translationX(500).setDuration(1500)
                        .setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case R.id.btn2:
                //匀速
                iv.animate().translationX(500).setDuration(1500)
                        .setInterpolator(new LinearInterpolator());
                break;
            case R.id.btn3:
                //持续加速，在整个动画过程中，一直在加速，直到动画结束的一瞬间，直接停止。
                iv.animate().translationX(500).setDuration(1500)
                        .setInterpolator(new AccelerateInterpolator());
                break;
            case R.id.btn4:
                //减速，动画开始的时候是最高速度，然后在动画过程中逐渐减速，直到动画结束的时候恰好减速到0。
                iv.animate().translationX(500).setDuration(1500)
                        .setInterpolator(new DecelerateInterpolator());
                break;
            case R.id.btn5:
                //先回拉一下再进行正常动画轨迹。效果看起来有点像投掷物体或跳跃等动作前的蓄力。
                iv.animate().translationX(500).setDuration(1500)
                        .setInterpolator(new AnticipateInterpolator());
                break;
            case R.id.btn6:
                //动画会超过目标值一些，然后再弹回来。
                iv.animate().translationX(500).setDuration(1500)
                        .setInterpolator(new OvershootInterpolator());
                break;
            case R.id.btn7:
                //开始前回拉，最后超过一些然后回弹。
                iv.animate().translationX(500).setDuration(1500)
                        .setInterpolator(new AnticipateOvershootInterpolator());
                break;
            case R.id.btn8:
                //在目标值处弹跳。有点像玻璃球掉在地板上的效果。
                iv.animate().translationX(500).setDuration(1500)
                        .setInterpolator(new BounceInterpolator());
                break;
        }
    }
}
