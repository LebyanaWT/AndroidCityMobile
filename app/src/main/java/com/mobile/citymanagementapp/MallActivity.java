package com.mobile.citymanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mobile.citymanagementapp.adapter.CityAdapter;
import com.mobile.citymanagementapp.adapter.MallAdapter;
import com.mobile.citymanagementapp.model.Mall;

import java.util.ArrayList;
import java.util.List;

public class MallActivity extends AppCompatActivity {

    RecyclerView viewList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerCityItemDecoration;
    private MallAdapter adapter;
    private List<Mall> malls_List;

    private RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        viewList = findViewById(R.id.mall_listview);

        malls_List = new ArrayList<>();
        setAdapter();

        TextView txtHeadin = findViewById(R.id.txtview_mall_heading);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            Intent i = getIntent();
            malls_List = (List<Mall>) i.getSerializableExtra("malls");
            MallAdapter adapter = new MallAdapter(MallActivity.this, malls_List,listener);
            viewList.setAdapter(adapter);
        }

    }

    private void setAdapter(){
        adapter = new MallAdapter(getApplicationContext(),malls_List,listener);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerCityItemDecoration = new DividerItemDecoration(viewList.getContext(), linearLayoutManager.getOrientation());
        viewList.setHasFixedSize(true);
        viewList.setLayoutManager(linearLayoutManager);
        viewList.addItemDecoration(dividerCityItemDecoration);
        viewList.setAdapter(adapter);
    }
}