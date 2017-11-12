package com.dabin.www.xinkaibin1508a20171107;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;


public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);

    }
    public void login(View view){
        String username = name.getText().toString();
        String password = pass.getText().toString();
        //发送消息  使用粘性
        EventBus.getDefault().postSticky(new First(username,password));


        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
