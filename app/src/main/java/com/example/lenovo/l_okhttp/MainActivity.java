package com.example.lenovo.l_okhttp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import java.io.IOException;

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
        okHttpUtil.requestGet(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String strRet = response.body().string();
                Message msg = mHandler.obtainMessage();
                msg.obj = "Post方法获取数据 ---> "+"  " +strRet;
                mHandler.sendMessage(msg);

            }
        });
    }

    public void httpGet() {
        okHttpUtil.requestGet(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String strRet = response.body().string();
                Message msg = mHandler.obtainMessage();
                msg.obj = "Get方法获取数据 ----> "+"  " + strRet;
                mHandler.sendMessage(msg);
            }
        });
    }
}
