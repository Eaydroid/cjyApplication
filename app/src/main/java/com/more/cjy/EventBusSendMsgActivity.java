package com.more.cjy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.more.cjy.bean.MessageEvent;
import com.more.cjy.bean.MessageEvent2;

import org.greenrobot.eventbus.EventBus;

public class EventBusSendMsgActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_send_msg);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("cjy", "123456"));
            }
        });
        findViewById(R.id.send2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent2("cjy2", "12345678"));
            }
        });
    }
}
