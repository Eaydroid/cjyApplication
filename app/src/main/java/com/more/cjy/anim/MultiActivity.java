package com.more.cjy.anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.more.cjy.R;

public class MultiActivity extends Activity {

    Button btn1;
    ImageView iv;
    boolean animated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        btn1 = (Button) findViewById(R.id.btn1);
        iv = (ImageView) findViewById(R.id.iv);
        iv.setScaleX(0.2f);
        iv.setScaleY(0.2f);
        iv.setAlpha(0.2f);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!animated) {
                    iv.animate()
                            .translationX(300)
                            .rotation(360)
                            .scaleX(2)
                            .scaleY(2)
                            .alpha(1)
                            .setDuration(3000);
                } else {
                    iv.animate()
                            .translationX(0)
                            .rotation(0)
                            .scaleX(0.2f)
                            .scaleY(0.2f)
                            .alpha(0.2f)
                            .setDuration(3000);
                }
                animated = !animated;
            }
        });
    }
}
