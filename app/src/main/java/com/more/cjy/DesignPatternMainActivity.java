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

        //单例模式
        btn_singleton = (Button) findViewById(R.id.btn_singleton);
        btn_singleton.setOnClickListener(this);

        //建造者模式
        btn_builder = (Button) findViewById(R.id.btn_builder);
        btn_builder.setOnClickListener(this);

        //适配器模式
        btn_adapter = (Button) findViewById(R.id.btn_adapter);
        btn_adapter.setOnClickListener(this);

        //工厂模式
        btn_factory = (Button) findViewById(R.id.btn_factory);
        btn_factory.setOnClickListener(this);

        //代理模式
        btn_proxy = (Button) findViewById(R.id.btn_proxy);
        btn_proxy.setOnClickListener(this);

        //享元模式
        btn_flyweight = (Button) findViewById(R.id.btn_flyweight);
        btn_flyweight.setOnClickListener(this);

        //观察者模式
        btn_observer = (Button) findViewById(R.id.btn_observer);
        btn_observer.setOnClickListener(this);

        //策略模式
        btn_strategy = (Button) findViewById(R.id.btn_strategy);
        btn_strategy.setOnClickListener(this);

        //命令模式
        btn_command = (Button) findViewById(R.id.btn_command);
        btn_command.setOnClickListener(this);

        //原型模式
        btn_prototype = (Button) findViewById(R.id.btn_prototype);
        btn_prototype.setOnClickListener(this);

        //装饰模式
        btn_decorate = (Button) findViewById(R.id.btn_decorate);
        btn_decorate.setOnClickListener(this);

        //外观模式
        btn_facade = (Button) findViewById(R.id.btn_facade);
        btn_facade.setOnClickListener(this);

        //组合模式
        btn_composite = (Button) findViewById(R.id.btn_composite);
        btn_composite.setOnClickListener(this);

        //桥接模式
        btn_bridge = (Button) findViewById(R.id.btn_bridge);
        btn_bridge.setOnClickListener(this);

        //模板模式
        btn_template = (Button) findViewById(R.id.btn_template);
        btn_template.setOnClickListener(this);

        //中介者模式
        btn_mediator = (Button) findViewById(R.id.btn_mediator);
        btn_mediator.setOnClickListener(this);

        //状态模式
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
