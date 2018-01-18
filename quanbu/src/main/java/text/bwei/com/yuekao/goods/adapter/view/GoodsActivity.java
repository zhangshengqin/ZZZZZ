package text.bwei.com.yuekao.goods.adapter.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import text.bwei.com.yuekao.R;
import text.bwei.com.yuekao.goods.adapter.MyGoodsAdpater;
import text.bwei.com.yuekao.goods.adapter.api.Apis;
import text.bwei.com.yuekao.goods.adapter.bean.Goods;
import text.bwei.com.yuekao.goods.adapter.presenter.presenterGoods;


public class GoodsActivity extends AppCompatActivity implements IgoodView {


    @BindView(R.id.recycler_goods)
    RecyclerView recycler_goods;


    private int pscid;
    private int page = 1;
    private LinearLayoutManager linearLayoutManager;
    private text.bwei.com.yuekao.goods.adapter.presenter.presenterGoods presenterGoods;
    private int uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ButterKnife.bind(this);

        uid = getIntent().getIntExtra("uid", 0);

//        EventBus.getDefault().register(this);
        presenterGoods = new presenterGoods(this);
        presenterGoods.getOkGood(Apis.GOOSDURL, 1, page, 0);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED, sticky = true)
//    public void getgoods(Messagechilde messagechilde) {
//        pscid = messagechilde.getPscid();
//
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//        presenterGoods.detach();//防内存溢出
//    }

    @Override
    public void showgoods(final List<Goods.DataBean> list) {
        linearLayoutManager = new LinearLayoutManager(this);
        recycler_goods.setLayoutManager(linearLayoutManager);
        recycler_goods.setAdapter(new MyGoodsAdpater(list, this, uid));


    }
}