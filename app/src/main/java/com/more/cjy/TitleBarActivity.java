package com.more.cjy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.more.cjy.titlebar.ImageAction;
import com.more.cjy.titlebar.PraiseAction;
import com.more.cjy.titlebar.TextAction;
import com.more.cjy.titlebar.TitleBarView;
import com.more.cjy.utils.MToast;

public class TitleBarActivity extends Activity {
    TitleBarView titleBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_bar);

        titleBarView = (TitleBarView) findViewById(R.id.titleBarView);
        titleBarView.setDividerColor(getResources().getColor(R.color.black));
        titleBarView.addLeftAction(new ImageAction(R.mipmap.base_back_black) {
            @Override
            public void performAction(View view) {
                finish();
            }
        });
        titleBarView.addLeftAction(new TextAction("关闭") {
            @Override
            public void performAction(View view) {
                finish();
            }
        });
        titleBarView.addCenterAction(new TextAction("标题") {
            @Override
            public void performAction(View view) {
                MToast.showToast("标题被点击了");
            }
        });
        titleBarView.addRightAction(new PraiseAction() {
            @Override
            public void performAction(View view) {
                super.performAction(view);
                MToast.showToast("点赞");
            }
        });
    }
}
