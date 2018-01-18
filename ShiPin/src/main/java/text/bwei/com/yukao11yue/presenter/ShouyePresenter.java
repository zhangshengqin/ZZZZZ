package text.bwei.com.yukao11yue.presenter;

import java.util.List;

import text.bwei.com.yukao11yue.MainActivity;
import text.bwei.com.yukao11yue.bean.ShouYe;
import text.bwei.com.yukao11yue.model.Imodel;
import text.bwei.com.yukao11yue.model.Onselectshouye;
import text.bwei.com.yukao11yue.model.model;
import text.bwei.com.yukao11yue.view.Iview;

/**
 * Created by dell on 2017/12/6.
 */

public class ShouyePresenter {
    Iview iview;
    Imodel imodel;

    public ShouyePresenter(MainActivity iview) {
        this.iview = iview;
        imodel = new model();
    }

    public void getShouye(String url) {
        imodel.RequestShouYe(url, new Onselectshouye() {
            @Override
            public void dataShouyeSuccess(List<ShouYe.RetBean.ListBean> list) {
                iview.showshouye(list);
            }
        });


    }


}
