package com.more.cjy.anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.more.cjy.R;

public class RotationActivity extends Activity implements View.OnClickListener {

    private ImageView iv;
    private Button btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                iv.animate().rotation(180);
                break;
            case R.id.btn2:
                iv.animate().rotationBy(90);
                break;
            case R.id.btn3:
                iv.animate().rotationX(180);
                break;
            case R.id.btn4:
                iv.animate().rotationXBy(45);
                break;
            case R.id.btn5:
                iv.animate().rotationY(180);
                break;
            case R.id.btn6:
                iv.animate().rotationYBy(45);
                break;
        }
    }
}
