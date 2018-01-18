package zhangshengqin.bwie.com.i.presenter;

import zhangshengqin.bwie.com.i.bean.DetailsBean;
import zhangshengqin.bwie.com.i.model.Idetailsmodel;
import zhangshengqin.bwie.com.i.model.OnselectDetails;
import zhangshengqin.bwie.com.i.model.model;
import zhangshengqin.bwie.com.i.view.Idetailsview;

/**
 * Created by 额头发 on 2018/1/8.
 */

public class presenterDetails {
    Idetailsview idetailsview;
    Idetailsmodel idetailsmodel;

    public presenterDetails(Idetailsview idetailsview) {
        this.idetailsview = idetailsview;
        idetailsmodel = new model();
    }

    public void getOkDetails(String url, int pid) {
        idetailsmodel.RequestDetails(url, pid, new OnselectDetails() {

            @Override

            public void dataDetailsSuccess(DetailsBean.DataBean list) {
                idetailsview.shouDetails(list);
            }

        });
    }
}
