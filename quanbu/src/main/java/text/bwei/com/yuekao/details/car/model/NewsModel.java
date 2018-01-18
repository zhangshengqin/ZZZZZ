package text.bwei.com.yuekao.details.car.model;


import java.util.List;

import io.reactivex.Flowable;
import text.bwei.com.yuekao.details.car.bean.DatasBean;
import text.bwei.com.yuekao.details.car.bean.MessageBean;
import text.bwei.com.yuekao.details.car.presenter.NewsPresenter;
import text.bwei.com.yuekao.details.car.utils.RetrofitUtils;


public class NewsModel implements IModel {
    private NewsPresenter presenter;

    public NewsModel(NewsPresenter presenter){
        this.presenter = (NewsPresenter) presenter;

    }
    @Override
    public void getData(String uid,String pid) {
        Flowable<MessageBean<List<DatasBean>>> flowable = RetrofitUtils
                .getInstance()
                .getApiService()
                .getDatas(uid);
        presenter.getNews(flowable);

    }
}