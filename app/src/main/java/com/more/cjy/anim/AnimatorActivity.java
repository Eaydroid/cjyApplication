package com.more.cjy.anim;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.app.Activity;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.more.cjy.R;

public class AnimatorActivity extends Activity implements View.OnClickListener {

    private ImageView iv;
    private MyProgress pb;
    private Button btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        iv = (ImageView) findViewById(R.id.iv);
        pb = (MyProgress) findViewById(R.id.pb);
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
    }

    @Override
    public void onClick(View v) {
        ObjectAnimator animator;
        switch (v.getId()) {
            case R.id.btn1:
//                Drawable drawable = iv.getBackground();
//                iv.setBackground(null);
//                ObjectAnimator animator = ObjectAnimator.ofInt(iv, "imageResource", R.mipmap.ic_launcher, R.mipmap.ic_launcher_round);
//                animator.setDuration(2000).setEvaluator(new IntEvaluator());
                animator = ObjectAnimator.ofFloat(iv, "alpha", 0, 1);
                animator.setDuration(2000).setEvaluator(new FloatEvaluator());
                animator.start();
                break;
            case R.id.btn2:
                animator = ObjectAnimator.ofInt(iv, "backgroundColor", 0xffff0000, 0xff00ff00);
                animator.setDuration(2000).setEvaluator(new IntEvaluator());
                animator.start();
                break;
            case R.id.btn3:
                animator = ObjectAnimator.ofInt(iv, "backgroundColor", 0xffff0000, 0xff00ff00);
                animator.setDuration(2000).setEvaluator(new ArgbEvaluator());
                animator.start();
                break;
            case R.id.btn4:
//                iv.setBackground(null);
//                animator = ObjectAnimator.ofObject(iv, "background", new DrawableEvaluater(),
//                        getResources().getDrawable(R.drawable.ic_launcher),
//                        getResources().getDrawable(R.drawable.ic_launcher_round));
//                animator.setDuration(2000).setEvaluator(new DrawableEvaluater());
//                animator.start();

//                animator = ObjectAnimator.ofObject(iv, "position",
//                        new PointFEvaluator(), new PointF(0, 0), new PointF(1, 1));
//                animator.start();
                iv.setAlpha(0);
                iv.setScaleX(0);
                iv.setScaleY(0);
                //下面等同iv.animate().scaleX(1).scaleY(1).alpha(1);
                PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("scaleX", 1);
                PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleY", 1);
                PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("alpha", 1);
                animator = ObjectAnimator.ofPropertyValuesHolder(iv, holder1, holder2, holder3);
                animator.start();
                break;
            case R.id.btn5:
//                ObjectAnimator animator0 = ObjectAnimator.ofFloat(iv, "alpha", 0, 1);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(iv, "scaleX", 0, 1).setDuration(500);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(iv, "scaleY", 0, 1).setDuration(500);
                animator1.setInterpolator(new LinearInterpolator());
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(iv, "translationX", 0, 500);
                animator3.setDuration(1000).setInterpolator(new AnticipateOvershootInterpolator());

                AnimatorSet animatorSet = new AnimatorSet();
                // 多个动画依次执行
//                animatorSet.playSequentially(animator1, animator2, animator3);
                // 多个动画同时执行
                animatorSet.playTogether(animator1, animator2, animator3);
                animatorSet.start();
                break;
            case R.id.btn6:
                //Keyframe （关键帧），把同一个动画属性拆分成多个阶段。
                // 例如，你可以让一个进度增加到 100% 后再「反弹」回来。
                pb.setVisibility(View.VISIBLE);
                // 在 0% 处开始
                Keyframe keyframe1 = Keyframe.ofFloat(0, 0);
                // 时间经过 50% 的时候，动画完成度 100%
                Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 100);
                // 时间见过 100% 的时候，动画完成度倒退到 80%，即反弹 20%
                Keyframe keyframe3 = Keyframe.ofFloat(1, 80);
                PropertyValuesHolder holder = PropertyValuesHolder
                        .ofKeyframe("progress", keyframe1, keyframe2, keyframe3);

                animator = ObjectAnimator.ofPropertyValuesHolder(pb, holder);
                animator.setDuration(1200).start();
                break;
        }
    }

    class DrawableEvaluater implements TypeEvaluator<Drawable> {

        @Override
        public Drawable evaluate(float fraction, Drawable startValue, Drawable endValue) {
            startValue = getResources().getDrawable(R.mipmap.ic_launcher);
            Drawable d = getResources().getDrawable(R.mipmap.ic_launcher_round);
            endValue = d;
            return d;
        }
    }

    private class PointFEvaluator implements TypeEvaluator<PointF> {
        PointF newPoint = new PointF();

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            float x = startValue.x + (fraction * (endValue.x - startValue.x));
            float y = startValue.y + (fraction * (endValue.y - startValue.y));

            newPoint.set(x, y);

            return newPoint;
        }
    }
}
