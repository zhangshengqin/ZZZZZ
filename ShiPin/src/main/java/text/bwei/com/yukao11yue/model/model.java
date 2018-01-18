package text.bwei.com.yukao11yue.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.yukao11yue.api.ApiService;
import text.bwei.com.yukao11yue.bean.Dianying;
import text.bwei.com.yukao11yue.bean.Pinlun;
import text.bwei.com.yukao11yue.bean.ShouYe;

/**
 * Created by dell on 2017/12/6.
 */

public class model implements Imodel {
    @Override
    public void RequestShouYe(String url, final Onselectshouye onselectshouye) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Observable<ShouYe> dataes = apiService.getDataes();

        dataes.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ShouYe>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShouYe shouYe) {
                        List<ShouYe.RetBean.ListBean> list = shouYe.getRet().getList();
                        onselectshouye.dataShouyeSuccess(list);

                    }
                });


    }

    @Override
    public void RequstShiping(String url, String mediaId, final Onsecond onsecond) {
        Map<String, String> map = new HashMap<>();
        map.put("mediaId", mediaId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Observable<Dianying> getdate = apiService.getdate("videoDetailApi/videoDetail.do", map);


        getdate.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Dianying>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Dianying dianying) {
                        Dianying.RetBean ret = dianying.getRet();
                        onsecond.dataSecondSuccess(ret);
                    }
                });


    }

    @Override
    public void RequstPinlun(String url, String mediaId, int pnum, final Onthree onthree) {

        Map<String, String> map = new HashMap<>();
        map.put("mediaId", mediaId);
        map.put("pnum", pnum + "");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<Pinlun> pinlunObservable = apiService.getdats1("Commentary/getCommentList.do", map);
        pinlunObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Pinlun>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Pinlun pinlun) {
                        List<Pinlun.RetBean.ListBean> list = pinlun.getRet().getList();
                        onthree.datapinlun(list);
                    }
                });


    }
}
