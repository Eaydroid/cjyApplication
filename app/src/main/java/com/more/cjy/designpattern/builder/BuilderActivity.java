package com.more.cjy.designpattern.builder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.more.cjy.R;

public class BuilderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
    }

    public void build(View view) {
        Person.Builder builder = new Person.Builder();
        builder.setName("cjy").setAge(30).setSex(1).setJob("coder");
        Person person = builder.build();
    }
}
