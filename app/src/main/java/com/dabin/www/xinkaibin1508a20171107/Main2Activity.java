package com.dabin.www.xinkaibin1508a20171107;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class Main2Activity extends AppCompatActivity {
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text = (TextView) findViewById(R.id.texts);
    }
    public void jieshou(View view){
        if(!EventBus.getDefault().isRegistered(this)){
            //注册
            EventBus.getDefault().register(this);
        }
    }



    //传值   使用粘性
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void OnEvent(First first) {
        text.setText("用户名："+first.getNames()+"密码："+first.getPasss());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        EventBus.getDefault().unregister(this);
    }
}
