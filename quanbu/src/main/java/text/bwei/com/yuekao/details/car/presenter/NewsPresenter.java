package text.bwei.com.yuekao.details.car.presenter;


import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import text.bwei.com.yuekao.details.car.bean.DatasBean;
import text.bwei.com.yuekao.details.car.bean.MessageBean;
import text.bwei.com.yuekao.details.car.model.NewsModel;
import text.bwei.com.yuekao.details.car.view.Iview;


public class NewsPresenter implements BasePresenter {
    private Iview iv;
    private DisposableSubscriber subscriber1;
//    private DisposableSubscriber subscriber2;

    public void attachView(Iview iv) {
        this.iv = iv;
    }

    public void detachView() {
        if (iv != null) {
            iv = null;
        }
        if (!subscriber1.isDisposed()){
            subscriber1.dispose();
        }
//        if (!subscriber2.isDisposed()){
//            subscriber2.dispose();
//        }
    }

    @Override
    public void getData(String uid,String pid) {
        NewsModel model = new NewsModel(this);
        model.getData(uid,pid);
    }

    public void getNews(Flowable<MessageBean<List<DatasBean>>> flowable) {
        subscriber1 = flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<MessageBean<List<DatasBean>>>() {
                    @Override
                    public void onNext(MessageBean<List<DatasBean>> listMessageBean) {
                        if (listMessageBean != null) {
                            List<DatasBean> list = listMessageBean.getData();
                            if (list != null) {
                                iv.onSuccess(list);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        iv.onFailed((Exception) t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

//    public void delData(Flowable<MessageBean> delFlowable) {
//        subscriber2 = delFlowable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableSubscriber<MessageBean>() {
//                    @Override
//                    public void onNext(MessageBean listMessageBean) {
//                        if (listMessageBean != null) {
//                            iv.delSuccess(listMessageBean);
//
//                        }
//                    }
//
//
//
//                    @Override
//                    public void onError(Throwable t) {
//                        iv.onFailed((Exception) t);
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
}