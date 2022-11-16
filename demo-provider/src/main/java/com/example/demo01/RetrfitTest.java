package com.example.demo01;

import com.example.demo01.entity.UserEntity;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

/**
 * @Description
 * @Date 2022/9/23
 * @Author lifengsheng
 */
public class RetrfitTest {

    public static void main(String[] args) {
        try {
            retrfitTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static final String API_URL = "http://localhost:8081/";
    private static void retrfitTest() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 创建User API接口的一个实例。
        UserApi userApi = retrofit.create(UserApi.class);
        // 创建一个调用实例
        Call<UserEntity> call = userApi.getUserById(5L);

        //Call<Object> call = userApi.addUser(new UserEntity(5L, "王武", "qwe", 25));


        //Call<List<Object>> call = userApi.getUserList("getUserList");
        //Call<Object> call = userApi.getHeaders();
        //Call<String> call = userApi.getHeader("Retrofit-Sample-App");

        //发送网络请求(异步)
        call.enqueue(new Callback<UserEntity>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                //请求处理,输出结果
                System.out.println(response.body());
            }

            //请求失败时候的回调
            @Override
            public void onFailure(Call<UserEntity> call, Throwable throwable) {
                System.out.println("连接失败");
            }
        });

        // 发送网络请求（同步）
        //Response<UserEntity> response = call.execute();
        //System.out.println(response.body());


        //获取并打印结果
        Response<UserEntity> response = call.execute();
        System.out.println(response);
        System.out.println(response.body());
    }


    public interface UserApi {
        @GET("user/{path}")
        Call<List<UserEntity>> getUserList(@Path("path") String path);

        @GET("/user/getUserById")
        Call<UserEntity> getUserById(@Query("id") Long id);

        @POST("/user/addUser")
        Call<Object> addUser(@Body UserEntity user);

        @GET("/user/getHeaders")
        @Headers({"User-Agent:Retrofit-Sample-App",
        "Cache-Control:no-cache"})
        Call<Object> getHeaders();

        @GET("/user/getHeaders")
        Call<String> getHeader(@Header("User-Agent") String userAgent);
    }
}

