package text.bwei.com.yuekao.goods.adapter.model;

import java.util.HashMap;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.yuekao.goods.adapter.api.ApiServers;
import text.bwei.com.yuekao.goods.adapter.bean.Goods;


/**
 * Created by dell on 2018/1/3.
 */

public class model implements Imodel {
//    http://120.27.23.105/product/getProducts?pscid=1&page=1&sort=0


    @Override
    public void RequestGoodsSuccess(String url, int pscid, int page, int sort, final OnselectGoods onselectGoods) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("pscid", pscid);
        map.put("page", page);
        map.put("sort", sort);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServers apiServers = retrofit.create(ApiServers.class);
        Observable<Goods> getdatgood = apiServers.getdatgood("product/getProducts", map);
        getdatgood.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Goods>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Goods goods) {
                        List<Goods.DataBean> data = goods.getData();
                        onselectGoods.dataGoods(data);
                    }
                });

    }
}