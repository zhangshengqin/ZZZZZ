package zhangshengqin.bwie.com.i.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zhangshengqin.bwie.com.i.api.ApiService;
import zhangshengqin.bwie.com.i.api.LoggingInterceptor;

/**
 * Created by 额头发 on 2018/1/8.
 */

public class RetrofitUtils {
    private static volatile RetrofitUtils instance;
    private ApiService apiService;
    private OkHttpClient client = new OkHttpClient
            .Builder()
            .addInterceptor(new LoggingInterceptor())
            .build();
    private RetrofitUtils(){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://120.27.23.105/")
                .build();
        apiService = retrofit.create(ApiService.class);

    }
    public static RetrofitUtils getInstance(){
        if (null==instance){
            synchronized (RetrofitUtils.class){
                if (instance==null){
                    instance = new RetrofitUtils();
                }

            }

        }
        return instance;
    }

    public ApiService getApiService(){
        return apiService;
    }

}
