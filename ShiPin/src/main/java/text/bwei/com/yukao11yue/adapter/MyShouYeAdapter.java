package text.bwei.com.yukao11yue.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.xbanner.XBanner;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import text.bwei.com.yukao11yue.R;
import text.bwei.com.yukao11yue.SecondActivity;
import text.bwei.com.yukao11yue.bean.MessEvent;
import text.bwei.com.yukao11yue.bean.ShouYe;

/**
 * Created by dell on 2017/12/6.
 */

public class MyShouYeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ShouYe.RetBean.ListBean> list;
    private Context context;

    public MyShouYeAdapter(List<ShouYe.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        ShouYe.RetBean.ListBean listBean = list.get(position);
        if (listBean.getShowType().equals("banner")) {
            return 0;
        } else {
            return 1;
        }
        //return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            MyViewHodelr myViewHodelr = new MyViewHodelr(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.topbanner, parent, false));
            return myViewHodelr;
        } else {
            MylistViewHodler mylistViewHodler = new MylistViewHodler(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.items, parent, false));
            return mylistViewHodler;
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final List<ShouYe.RetBean.ListBean.ChildListBean> childList = list.get(position).getChildList();
        if (holder instanceof MyViewHodelr) {
            final List<String> imgs = new ArrayList<>();
            List<ShouYe.RetBean.ListBean.ChildListBean> ban = list.get(0).getChildList();
            for (int i = 0; i < ban.size(); i++) {
                imgs.add(ban.get(i).getPic());
            }
            ((MyViewHodelr) holder).banner.setData(imgs, null);
            ((MyViewHodelr) holder).banner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(context).load(imgs.get(position)).into((ImageView) view);
                }
            });

        } else if (holder instanceof MylistViewHodler) {
            ((MylistViewHodler) holder).itemTv.setText(childList.get(0).getTitle());
            if (childList.get(0).getPic() != null) {
                Uri uri = Uri.parse(childList.get(0).getPic());
                ((MylistViewHodler) holder).img.setImageURI(uri);
            }
            ((MylistViewHodler) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventBus.getDefault().postSticky(new MessEvent(childList.get(0).getDataId(), childList.get(0).getTitle()));
                    Intent intent = new Intent(context, SecondActivity.class);
                    context.startActivity(intent);
                }
            });


        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class MyViewHodelr extends RecyclerView.ViewHolder {
        //        @BindView(R.id.banner)
        XBanner banner;

        public MyViewHodelr(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    static class MylistViewHodler extends RecyclerView.ViewHolder {
        //        @BindView(R.id.item_img)
        SimpleDraweeView img;
        //        @BindView(R.id.item_tv)
        TextView itemTv;

        public MylistViewHodler(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_img);
            itemTv = itemView.findViewById(R.id.item_tv);
        }
    }

}


