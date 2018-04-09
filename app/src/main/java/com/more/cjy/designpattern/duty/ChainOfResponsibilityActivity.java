package com.more.cjy.designpattern.duty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.more.cjy.R;
/**
 * @author cjy 2018-04-09
 * 责任链模式场景：继承抽象链对象，每一个具体对象内部包含一个next对象引用
 * 优点：1.降低耦合度，便于拓展，提高代码灵活性。
 *      2.责任链对象互相链接，只用想头部发起请求。
 * 缺点：1.如果责任链太长，或者每条链判断处理的时间太长会影响性能。特别是递归循环的时候。
 *      2.请求不一定能得到处理，可能会没有对象处理。
 * */
public class ChainOfResponsibilityActivity extends Activity implements View.OnClickListener {
    private Button btn1, btn2, btn3, btn4;
    private Leader teamLeader, director, cto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chain_of_responsibility);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        teamLeader = new TeamLeader();
        director = new Director();
        cto = new CTO();
        teamLeader.higherLeader = director;
        director.higherLeader = cto;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn1:
                teamLeader.handleRequest(3500);
                break;
            case R.id.btn2:
                teamLeader.handleRequest(7000);
                break;
            case R.id.btn3:
                teamLeader.handleRequest(12000);
                break;
            case R.id.btn4:
                teamLeader.handleRequest(25000);
                break;
        }
    }
}
