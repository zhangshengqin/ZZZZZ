package com.example.summary.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.summary.R;
import com.example.summary.adapter.ProductsAdapter;
import com.example.summary.bean.ProductsBean;
import com.example.summary.presenter.PresenterProducts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsActivity extends AppCompatActivity implements IView{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private PresenterProducts presenterProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);
        Map<String,String> map=new HashMap<>();
        map.put("pscid","39");
        map.put("page","1");
        presenterProducts = new PresenterProducts(this);
        presenterProducts.getData("https://www.zhaoapi.cn/",map);

    }



    @Override
    public void Success(Object o) {
        ProductsBean productsBean= (ProductsBean) o;
        List<ProductsBean.DataBean> data = productsBean.getData();
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        ProductsAdapter adapter=new ProductsAdapter(this,data);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void Failed(Throwable t) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterProducts.deletchView();
    }
}
