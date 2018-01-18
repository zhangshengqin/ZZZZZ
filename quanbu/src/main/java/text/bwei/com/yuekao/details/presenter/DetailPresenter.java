package text.bwei.com.yuekao.details.presenter;


import text.bwei.com.yuekao.details.GoodConstract;
import text.bwei.com.yuekao.details.bean.AddBean;
import text.bwei.com.yuekao.details.bean.DetailsBean;
import text.bwei.com.yuekao.details.model.GoodModel;

public class DetailPresenter implements GoodConstract.IDetailPresenter {
    GoodConstract.IDetailsView iDetailsView;
    GoodConstract.IGoodModel iGoodModel;

    public DetailPresenter(GoodConstract.IDetailsView iDetailsView) {
        this.iDetailsView = iDetailsView;
        iGoodModel = new GoodModel();
    }

    @Override
    public void LoadDetails(String url, int pid) {
        iGoodModel.requestDetails(url, pid, new GoodConstract.OnDetailsListener() {
            @Override
            public void onSuccess(DetailsBean list) {
                iDetailsView.ShowList(list);
            }

            @Override
            public void onError(String e) {
                iDetailsView.ShowError(e);
            }
        });
    }

    @Override
    public void LoadAdd(String url, int uid, int pid, int sellerid) {
        iGoodModel.requestAdd(url, uid, pid, sellerid, new GoodConstract.OnAddListener() {
            @Override
            public void onSuccess(AddBean addBean) {
                iDetailsView.AddShop(addBean);
            }

            @Override
            public void onError(String e) {
                iDetailsView.AddError(e);
            }
        });
    }
}