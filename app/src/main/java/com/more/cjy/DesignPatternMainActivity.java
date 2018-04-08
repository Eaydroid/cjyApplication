package com.more.cjy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DesignPatternMainActivity extends Activity implements View.OnClickListener {

    private Button btn_singleton, btn_builder, btn_adapter, btn_factory,
            btn_proxy, btn_flyweight, btn_observer, btn_strategy, btn_command,
            btn_prototype, btn_decorate, btn_facade, btn_composite, btn_bridge,
            btn_template, btn_mediator, btn_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_pattern_main);

        btn_singleton = (Button) findViewById(R.id.btn_singleton);
        btn_singleton.setOnClickListener(this);

        btn_builder = (Button) findViewById(R.id.btn_builder);
        btn_builder.setOnClickListener(this);

        btn_adapter = (Button) findViewById(R.id.btn_adapter);
        btn_adapter.setOnClickListener(this);

        btn_factory = (Button) findViewById(R.id.btn_factory);
        btn_factory.setOnClickListener(this);

        btn_proxy = (Button) findViewById(R.id.btn_proxy);
        btn_proxy.setOnClickListener(this);

        btn_flyweight = (Button) findViewById(R.id.btn_flyweight);
        btn_flyweight.setOnClickListener(this);

        btn_observer = (Button) findViewById(R.id.btn_observer);
        btn_observer.setOnClickListener(this);

        btn_strategy = (Button) findViewById(R.id.btn_strategy);
        btn_strategy.setOnClickListener(this);

        btn_command = (Button) findViewById(R.id.btn_command);
        btn_command.setOnClickListener(this);

        btn_prototype = (Button) findViewById(R.id.btn_prototype);
        btn_prototype.setOnClickListener(this);

        btn_decorate = (Button) findViewById(R.id.btn_decorate);
        btn_decorate.setOnClickListener(this);

        btn_facade = (Button) findViewById(R.id.btn_facade);
        btn_facade.setOnClickListener(this);

        btn_composite = (Button) findViewById(R.id.btn_composite);
        btn_composite.setOnClickListener(this);

        btn_bridge = (Button) findViewById(R.id.btn_bridge);
        btn_bridge.setOnClickListener(this);

        btn_template = (Button) findViewById(R.id.btn_template);
        btn_template.setOnClickListener(this);

        btn_mediator = (Button) findViewById(R.id.btn_mediator);
        btn_mediator.setOnClickListener(this);

        btn_state = (Button) findViewById(R.id.btn_state);
        btn_state.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_singleton:
                break;
            case R.id.btn_builder:
                break;
            case R.id.btn_adapter:
                break;
            case R.id.btn_factory:
                break;
            case R.id.btn_proxy:
                break;
            case R.id.btn_flyweight:
                break;
            case R.id.btn_observer:
                break;
            case R.id.btn_strategy:
                break;
            case R.id.btn_command:
                break;
            case R.id.btn_prototype:
                break;
            case R.id.btn_decorate:
                break;
            case R.id.btn_facade:
                break;
            case R.id.btn_composite:
                break;
            case R.id.btn_bridge:
                break;
            case R.id.btn_template:
                break;
            case R.id.btn_mediator:
                break;
            case R.id.btn_state:
                break;
        }
    }
}
