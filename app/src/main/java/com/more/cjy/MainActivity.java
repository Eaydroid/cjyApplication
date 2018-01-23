package com.more.cjy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btn_circleBar;
    private Button btn_titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_circleBar = (Button) findViewById(R.id.btn_circleBar);
        btn_circleBar.setOnClickListener(this);
        btn_titleBar = (Button) findViewById(R.id.btn_titleBar);
        btn_titleBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_circleBar:
                break;
            case R.id.btn_titleBar:
                startActivity(new Intent(MainActivity.this, TitleBarActivity.class));
                break;
        }
    }
}
