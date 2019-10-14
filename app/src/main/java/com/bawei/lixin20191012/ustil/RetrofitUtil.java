package com.bawei.lixin20191012.ustil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
   private static ApiServer apiServer;
    //单例模式
   public static  ApiServer getApiServer(){
       if (apiServer==null){
           synchronized (RetrofitUtil.class){
               if (apiServer==null){
                   apiServer=new RetrofitUtil().getRetrofit();
               }
           }
       }
       return apiServer;
   }
   private RetrofitUtil(){}
   public ApiServer getRetrofit(){
       //初始化retrofit
       ApiServer apiServer = initPetrofitn(initOkHttp()).create(ApiServer.class);
       return apiServer;
   }
   //初始化 okhttp
    private OkHttpClient initOkHttp(){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Response response = chain.proceed(request);
                        return response;
                    }
                })//添加打印拦截器
                .retryOnConnectionFailure(true)//设置出现错误从新连接
                .build();
        return okHttpClient;
    }
    //初始化 retrofit
    private Retrofit initPetrofitn(OkHttpClient client){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Constans.BaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
