package com.example.lenovo.l_okhttp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.lenovo.l_okhttp.R.id.btn_Post;
import static com.example.lenovo.l_okhttp.R.id.btn_get;
import static com.example.lenovo.l_okhttp.R.id.tv_show_msg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mButtonGet,mButtonPost;
    private TextView mViewShow;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        mButtonPost.setOnClickListener(this);
        mButtonGet.setOnClickListener(this);
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                mViewShow.setText((String) msg.obj);
            }
        };

    }

    private void initView() {
        mButtonGet = (Button) findViewById(btn_get);
        mButtonPost = (Button) findViewById(btn_Post);
        mViewShow = (TextView) findViewById(tv_show_msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case btn_get:
                httpGet();
                break;
            case R.id.btn_Post:
                httpPost();
                break;
        }
    }

    private void httpPost() {

    }

    public void httpGet() {

    }
}
