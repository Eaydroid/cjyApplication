package com.more.cjy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.more.cjy.bean.MessageEvent;
import com.more.cjy.bean.MessageEvent2;
import com.more.cjy.utils.MToast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusMainActivity extends Activity {
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_main);

        EventBus.getDefault().register(EventBusMainActivity.this);
        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_result.setText(new MessageEvent("old msg", "111111").toString());

        findViewById(R.id.jumpToSendMsgActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventBusMainActivity.this, EventBusSendMsgActivity.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void update(MessageEvent event) {
        tv_result.setText(event.toString());
        MToast.showToast("更新了数据");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void update(MessageEvent2 event) {
        tv_result.setText(event.toString());
        MToast.showToast("更新了数据2");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(EventBusMainActivity.this);
    }
}
