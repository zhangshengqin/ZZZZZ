package text.bwei.com.yuekao.details.utils;


import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import text.bwei.com.yuekao.details.bean.AddBean;
import text.bwei.com.yuekao.details.bean.DetailsBean;
import text.bwei.com.yuekao.details.bean.GoodBean;


public interface ApiServer {
//    @POST
//    Observable<SignUpBean> getsup(@Url String url, @QueryMap Map<String,String> map);
//    @POST
//    Observable<LoginBean> getlg(@Url String url, @QueryMap Map<String,String> map);
//
//    @GET("product/getCatagory")
//    Observable<OneBean> getonedata();
//
//    @GET("ad/getAd")
//    Observable<BannerBean> getbanner();
//
//    @POST
//    Observable<TwoBean> getRight(@Url String url, @QueryMap Map<String,Integer> map);

    @POST
    Observable<GoodBean> getgood(@Url String url, @QueryMap Map<String, Integer> map);

    @POST
    Observable<DetailsBean> getdetail(@Url String url, @QueryMap Map<String, String> map);

    @POST
    Observable<AddBean> getAdd(@Url String url, @QueryMap Map<String, String> map);

//    @POST
//    Observable<ShopCarBean> getcatlist(@Url String url, @QueryMap Map<String,String> map);
//
//    @POST
//    Observable<DeleteBean> getdeta(@Url String url, @QueryMap Map<String,String> map);
}