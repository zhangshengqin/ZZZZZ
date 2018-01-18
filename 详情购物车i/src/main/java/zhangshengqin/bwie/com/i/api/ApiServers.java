package zhangshengqin.bwie.com.i.api;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import zhangshengqin.bwie.com.i.bean.DetailsBean;

/**
 * Created by 额头发 on 2018/1/8.
 */

public interface ApiServers {
    @POST
    Observable<DetailsBean> getdataDetails(@Url String url, @QueryMap Map<String, Integer> map);

}
