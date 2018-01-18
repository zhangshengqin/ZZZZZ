package text.bwei.com.yukao11yue.api;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import text.bwei.com.yukao11yue.bean.Dianying;
import text.bwei.com.yukao11yue.bean.Pinlun;
import text.bwei.com.yukao11yue.bean.ShouYe;

/**
 * Created by dell on 2017/12/6.
 */

public interface ApiService {
    @GET("homePageApi/homePage.do")
    Observable<ShouYe> getDataes();


    @POST
    Observable<Dianying> getdate(@Url String url, @QueryMap Map<String, String> map);



    @POST
    Observable<Pinlun> getdats1(@Url String url, @QueryMap Map<String, String> map);


}
