package com.mobile.citymanagementapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.citymanagementapp.adapter.MallAdapter;
import com.mobile.citymanagementapp.adapter.ShopAdapter;
import com.mobile.citymanagementapp.model.Mall;
import com.mobile.citymanagementapp.model.Shop;

import java.util.List;

public class activity_shop extends AppCompatActivity {


    RecyclerView viewList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerCityItemDecoration;
    private ShopAdapter adapter;
    private List<Shop> shops_List;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        setAdapter();
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            Intent i = getIntent();
            shops_List = (List<Shop>) i.getSerializableExtra("malls");
            ShopAdapter adapter = new ShopAdapter(getApplicationContext(), shops_List);
            viewList.setAdapter(adapter);
        }

    }


    private void setAdapter(){
        adapter = new ShopAdapter(getApplicationContext(),shops_List);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerCityItemDecoration = new DividerItemDecoration(viewList.getContext(), linearLayoutManager.getOrientation());
        viewList.setHasFixedSize(true);
        viewList.setLayoutManager(linearLayoutManager);
        viewList.addItemDecoration(dividerCityItemDecoration);
        viewList.setAdapter(adapter);
    }
}