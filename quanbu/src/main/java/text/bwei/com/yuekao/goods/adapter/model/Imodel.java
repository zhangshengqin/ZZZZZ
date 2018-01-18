package text.bwei.com.yuekao.goods.adapter.model;

public interface Imodel {
    //    pscid=1&page=1&sort=0
    void RequestGoodsSuccess(String url, int pscid, int page, int sort, OnselectGoods onselectGoods);


}