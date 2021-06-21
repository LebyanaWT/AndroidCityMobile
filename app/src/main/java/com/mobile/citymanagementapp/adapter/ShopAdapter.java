package com.mobile.citymanagementapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.citymanagementapp.R;

import com.mobile.citymanagementapp.model.Shop;

import java.util.List;

public class ShopAdapter  extends RecyclerView.Adapter<ShopAdapter.ViewHolder>{

    private Context context;
    private List<Shop> shops_list;

    public ShopAdapter(Context context,
                       List<Shop> list) {
        this.context = context;
        this.shops_list = list;

    }

    @NonNull
    @Override
    public ShopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.activity_mall_itemview,
                        parent, false);
        return new ShopAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  ShopAdapter.ViewHolder holder, int position) {
        Shop shop = shops_list.get(position);
        holder.txtShopId.setText(String.valueOf(shop.getId()));
        holder.txtShopName.setText(String.valueOf(shop.getName()));
    }


    @Override
    public int getItemCount() {
        return shops_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtShopId, txtShopName, text;

        public ViewHolder(View itemView) {
            super(itemView);
            txtShopId = itemView.findViewById(R.id.txt_Shop_id);
            txtShopName = itemView.findViewById(R.id.txtv_shop_name);
        }

    }
}
