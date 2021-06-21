package com.mobile.citymanagementapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.citymanagementapp.R;
import com.mobile.citymanagementapp.RecyclerViewClickListener;
import com.mobile.citymanagementapp.model.Mall;

import java.util.List;

public class MallAdapter extends RecyclerView.Adapter<MallAdapter.ViewHolder>{

    private Context context;
    private List<Mall> malls_list;
    private RecyclerViewClickListener listener;

    public MallAdapter(Context context,
                       List<Mall> list,
                       RecyclerViewClickListener listener) {
        this.context = context;
        this.malls_list = list;
        this.listener = listener;

    }

    @NonNull
    @Override
    public MallAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.activity_mall_itemview,
                        parent, false);
        return new MallAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  MallAdapter.ViewHolder holder, int position) {

        Mall mall = malls_list.get(position);
        holder.txtShopName.setText(String.valueOf(mall.getName()));

    }

    @Override
    public int getItemCount() {
        return malls_list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtShopId, txtShopName, text;

        public ViewHolder(View itemView) {
            super(itemView);
            txtShopName = itemView.findViewById(R.id.txtview_mall_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v , getAdapterPosition());
        }
    }
}
