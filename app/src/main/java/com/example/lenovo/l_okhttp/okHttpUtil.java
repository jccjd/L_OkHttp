package com.example.lenovo.l_okhttp;

import okhttp3.*;

public class okHttpUtil {
    public static void requestGet(Callback callback) {
        String BASE_URL = "http://10.0.2.2/get.php?key=get";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(BASE_URL).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    public static void requestPost(Callback callback) {
        String BASE_URL = "http://10.0.2.2/post.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody formBody = new FormBody.Builder().add("key", "Post").build();
        Request request = new Request.Builder().url(BASE_URL).post(formBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

}
