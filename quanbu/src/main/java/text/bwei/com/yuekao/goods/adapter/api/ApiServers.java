package text.bwei.com.yuekao.goods.adapter.api;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import text.bwei.com.yuekao.goods.adapter.bean.Goods;

/**
 * Created by dell on 2018/1/3.
 */

public interface ApiServers {
    @POST
    Observable<Goods> getdatgood(@Url String url, @QueryMap Map<String,Integer> map);
}