package com.more.cjy.designpattern.singleton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.more.cjy.R;
import com.more.cjy.utils.MToast;

/**
 * @author cjy 2018-04-08
 * 单例模式
 * 保持程序运行的时候该中始终只有一个实例存在内存中
 * 对于那些比较耗内存的类，只实例化一次可以大大提高性能，尤其是在移动开发中。
 * */
public class SingletonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);
    }

    public void createInstance(View view) {
        MToast.showToast("单例：" + Singleton.getInstance());
    }
}
