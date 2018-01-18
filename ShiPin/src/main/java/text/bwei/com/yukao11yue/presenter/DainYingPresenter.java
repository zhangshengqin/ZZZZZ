package text.bwei.com.yukao11yue.presenter;

import text.bwei.com.yukao11yue.bean.Dianying;
import text.bwei.com.yukao11yue.model.Imodel;
import text.bwei.com.yukao11yue.model.Onsecond;
import text.bwei.com.yukao11yue.model.model;
import text.bwei.com.yukao11yue.view.IsecondView;

/**
 * Created by dell on 2017/12/7.
 */

public class DainYingPresenter {
    IsecondView isecondView;
    Imodel imodel;

    public DainYingPresenter(IsecondView isecondView) {
        this.isecondView = isecondView;
        imodel = new model();
    }

    public void getSecond(String url, String mediaId) {
        imodel.RequstShiping(url, mediaId, new Onsecond() {
            @Override
            public void dataSecondSuccess(Dianying.RetBean list) {
                isecondView.shouVido(list);
            }
        });


    }


}
