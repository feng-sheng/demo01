package com.example.demo01.api;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @Description
 * @Date 2022/9/23
 * @Author lifengsheng
 */
public interface NetworkApi {
    @GET("www.baidu.com")
    Call<String> query();
}
