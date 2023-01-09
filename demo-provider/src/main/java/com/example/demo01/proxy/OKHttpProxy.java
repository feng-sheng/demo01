package com.example.demo01.proxy;

import com.alibaba.fastjson.JSONObject;
import com.example.demo01.entity.UserEntity;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/9 17:06
 * @Desc:
 */
public class OKHttpProxy {
    public static void main(String[] args) throws IOException {
        testAddUser();
    }

    public static void testAddUser() throws IOException {
        UserEntity user = new UserEntity();
        user.setUsername("xiao-li");
        user.setAge(102);
        user.setPassword("qwe123");

        String content = JSONObject.toJSONString(user);

        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), content);
        Request request = new Request.Builder()
                .url("http://localhost:8082/user/addUser")
                .post(requestBody)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response);
        if (response.isSuccessful() && response.body() != null) {
            System.out.println(JSONObject.parseObject(response.body().string()).getBoolean("result"));
        }
    }
}
