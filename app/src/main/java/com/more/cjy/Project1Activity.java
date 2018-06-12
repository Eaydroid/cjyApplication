package com.more.cjy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.more.cjy.widget.CirclePercentView;

public class Project1Activity extends Activity {
    private CirclePercentView circlePercentView, circlePercentView2;
    private SeekBar seekBar;
    private Button btn;
    private int selectFlag = 0;
    private CirclePercentView[] circlePercentViews = new CirclePercentView[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project1);

        circlePercentView = (CirclePercentView) findViewById(R.id.circlePercentView);
//        circlePercentView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                circlePercentView.setTextColor(Color.parseColor("#fd6028"));
//            }
//        });
        circlePercentView.setText("Shoulder");
        circlePercentView.setListener(new CirclePercentView.MyOnClickListener() {
            @Override
            public void onClick() {
//                seekBar.setVisibility(View.VISIBLE);
                selectFlag = 0;
                seekBar.setProgress((int) circlePercentViews[selectFlag].getProgress());
                circlePercentViews[selectFlag].setBg((int) circlePercentViews[selectFlag].getProgress());
                circlePercentViews[selectFlag].setState(CirclePercentView.STATE_SELECT);
            }

            @Override
            public void onClickEnd() {
                if(circlePercentViews[selectFlag].getProgress() == 0) {

                }
//                seekBar.setProgress(0);
//                seekBar.setVisibility(View.INVISIBLE);
            }
        });

        circlePercentView2 = (CirclePercentView) findViewById(R.id.circlePercentView2);
//        circlePercentView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                circlePercentView.setTextColor(Color.parseColor("#fd6028"));
//            }
//        });
        circlePercentView2.setText("Chest");
        circlePercentView2.setListener(new CirclePercentView.MyOnClickListener() {
            @Override
            public void onClick() {
                selectFlag = 1;
                seekBar.setProgress((int) circlePercentViews[selectFlag].getProgress());
                circlePercentViews[selectFlag].setBg((int) circlePercentViews[selectFlag].getProgress());
                circlePercentViews[selectFlag].setState(CirclePercentView.STATE_SELECT);
            }

            @Override
            public void onClickEnd() {
//                seekBar.setProgress(0);
//                seekBar.setVisibility(View.INVISIBLE);
            }
        });

        circlePercentViews[0] = circlePercentView;
        circlePercentViews[1] = circlePercentView2;

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circlePercentViews[selectFlag].setState(CirclePercentView.STATE_CHANGE);
                circlePercentViews[selectFlag].setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
