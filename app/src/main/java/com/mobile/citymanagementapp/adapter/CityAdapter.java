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
import com.mobile.citymanagementapp.model.City;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private Context context;
    private List<City> cities_list;

    private RecyclerViewClickListener clickListener;

    public CityAdapter(Context context,
                       List<City> list,
                       RecyclerViewClickListener listener) {
        this.context = context;
        this.cities_list = list;
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(
            @NonNull  ViewGroup parent,
            int viewType) {
            View v = LayoutInflater.from(context)
                .inflate(R.layout.activity_city_itemview,
                        parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(
            @NonNull CityAdapter.ViewHolder holder,
            int position) {

        City city = cities_list.get(position);
        holder.textviewId.setText(String.valueOf(city.getId()));
        holder.textCityName.setText(String.valueOf(city.getName()));

    }

    @Override
    public int getItemCount() {
         return cities_list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textviewId, textCityName, text;

        public ViewHolder(View itemView) {
            super(itemView);
            textviewId = itemView.findViewById(R.id.txtview_city_id);
            textCityName = itemView.findViewById(R.id.txtview_city_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view , getAdapterPosition());
        }
    }

}
