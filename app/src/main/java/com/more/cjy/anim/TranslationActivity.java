package com.more.cjy.anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.more.cjy.R;

public class TranslationActivity extends Activity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        iv = (ImageView) findViewById(R.id.iv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                iv.animate().translationX(200);
                break;
            case R.id.btn2:
                iv.animate().translationXBy(200);
                break;
            case R.id.btn3:
                iv.animate().translationY(100);
                break;
            case R.id.btn4:
                iv.animate().translationYBy(100);
                break;
        }
    }
}
