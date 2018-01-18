package zhangshengqin.bwie.com.i.api;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zhangshengqin.bwie.com.i.bean.DatasBean;
import zhangshengqin.bwie.com.i.bean.MessageBean;

/**
 * Created by 额头发 on 2018/1/8.
 */

public interface ApiService {
    //    http://120.27.23.105/product/deleteCart?uid=72&pid=1
    @GET("product/getCarts")
    Flowable<MessageBean<List<DatasBean>>> getDatas(@Query("uid") String uid);
    @GET("product/deleteCart")
    Flowable<MessageBean> deleteData(@Query("uid") String uid, @Query("pid") String pid);

}
