package com.more.cjy.anim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.more.cjy.R;

public class AnimMainActivity extends Activity implements View.OnClickListener {

    private Button btn_trans, btn_rotation, btn_scale, btn_alpha, btn_multi, btn_interpolater, btn_btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root);

        btn_trans = (Button) findViewById(R.id.btn1);
        btn_trans.setOnClickListener(this);
        btn_rotation = (Button) findViewById(R.id.btn2);
        btn_rotation.setOnClickListener(this);
        btn_scale = (Button) findViewById(R.id.btn3);
        btn_scale.setOnClickListener(this);
        btn_alpha = (Button) findViewById(R.id.btn4);
        btn_alpha.setOnClickListener(this);
        btn_multi = (Button) findViewById(R.id.btn5);
        btn_multi.setOnClickListener(this);
        btn_interpolater = (Button) findViewById(R.id.btn6);
        btn_interpolater.setOnClickListener(this);
        btn_btn7 = (Button) findViewById(R.id.btn7);
        btn_btn7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(AnimMainActivity.this, TranslationActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(AnimMainActivity.this, RotationActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(AnimMainActivity.this, ScaleActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(AnimMainActivity.this, AlphaActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(AnimMainActivity.this, MultiActivity.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(AnimMainActivity.this, InterpolaterActivity.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(AnimMainActivity.this, AnimatorActivity.class));
                break;
        }
    }
}
