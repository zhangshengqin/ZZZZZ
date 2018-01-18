package text.bwei.com.yuekao.details;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.yuekao.R;
import text.bwei.com.yuekao.details.bean.AddBean;
import text.bwei.com.yuekao.details.car.view.SecondActivity;
import text.bwei.com.yuekao.details.presenter.DetailPresenter;
import text.bwei.com.yuekao.goods.adapter.api.MessageDetails;
import text.bwei.com.yuekao.utils.Api;
import text.bwei.com.yuekao.utils.Toasts;

/**
 * Created by dell on 2018/1/13.
 */

public class DetailsActivity extends AppCompatActivity implements GoodConstract.IDetailsView {


    @BindView(R.id.detail_banner)
    XBanner detailBanner;
    @BindView(R.id.details_title)
    TextView detailsTitle;
    @BindView(R.id.details_text)
    TextView detailsText;
    @BindView(R.id.details_price)
    TextView detailsPrice;
    @BindView(R.id.buy_now)
    Button buyNow;
    @BindView(R.id.add_cart)
    Button addCart;
    private DetailPresenter detailPresenter;
    private int sellerid;
    private int pid;
    private int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        uid = getIntent().getIntExtra("uid",0);

        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        detailPresenter = new DetailPresenter(this);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        int hei = (point.y) / 2;
        ViewGroup.LayoutParams params = detailBanner.getLayoutParams();
        params.height = hei;
        detailBanner.setLayoutParams(params);
//        detailPresenter.LoadDetails(Api.BANNERURL, 2);
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED, sticky = true)
    public void getDetails(MessageDetails detailsEvent) {
        //tvEee.setText(detailsEvent.getCid()+"");
        detailPresenter.LoadDetails(Api.BANNERURL, detailsEvent.getPid());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



    @Override
    public void ShowList(text.bwei.com.yuekao.details.bean.DetailsBean list) {
//        DetailsBean.SellerBean seller = lists.getSeller();
//        sellerid = seller.getSellerid();
//        DetailsBean.DataBean list = lists.getData();
//        pid = list.getPid();
        final List<String> img_list = new ArrayList<>();
        String images = list.getData().getImages();
        String[] split = images.split("\\|");
        for (int i = 0; i < split.length; i++) {
            img_list.add(split[i]);
        }
        detailBanner.setData(img_list, null);
        detailBanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(DetailsActivity.this).load(img_list.get(position)).into((ImageView) view);
            }
        });
        detailsTitle.setText(list.getData().getTitle());
        detailsPrice.setText("￥ " + list.getData().getPrice() + "");
        detailsText.setText(list.getData().getSubhead());
    }

    @Override
    public void AddShop(AddBean addBean) {
        Toasts.showLong(this, addBean.getMsg());
    }

    @Override
    public void AddError(String e) {
        Toasts.showLong(this, e);
    }

    @Override
    public void ShowError(String e) {
        Toasts.showLong(this, e);
        Log.e("哈哈哈哈哈哈啊哈", e);
    }

    @OnClick({R.id.buy_now, R.id.add_cart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buy_now:

                Intent intent = new Intent(DetailsActivity.this, SecondActivity.class);
                intent.putExtra("uid", uid);
                startActivity(intent);


                break;
            case R.id.add_cart:
//                SharedPreferences user = getSharedPreferences("USER", MODE_PRIVATE);
//                SharedPreferences.Editor edit = user.edit();
//                edit.putString("pid",""+pid);
//                edit.commit();
//                String name = user.getString("name", "000");
//                int uid = user.getInt("uid", 0);
                detailPresenter.LoadAdd(Api.BANNERURL, uid, pid, sellerid);
                break;

        }
    }
}