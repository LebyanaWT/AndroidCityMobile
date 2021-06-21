package com.mobile.citymanagementapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mobile.citymanagementapp.adapter.CityAdapter;
import com.mobile.citymanagementapp.model.City;
import com.mobile.citymanagementapp.model.Mall;
import com.mobile.citymanagementapp.model.Shop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView viewList;
    private String cities_json_url = "https://run.mocky.io/v3/627b0be8-942f-4d2e-ab59-a5f73124b252";
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerCityItemDecoration;
    private List<City> cities_List;


    private List<Mall> malls_List;
    private List<Shop> shops_List;
    private CityAdapter adapter;

    private RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewList = findViewById(R.id.cities_listview);
        cities_List = new ArrayList<>();
        shops_List = new ArrayList<>();
        setAdapter();
        getCites();

    }
    private void setAdapter(){
        adapter = new CityAdapter(getApplicationContext(),cities_List,listener);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerCityItemDecoration = new DividerItemDecoration(viewList.getContext(), linearLayoutManager.getOrientation());
        viewList.setHasFixedSize(true);
        viewList.setLayoutManager(linearLayoutManager);
        viewList.addItemDecoration(dividerCityItemDecoration);
        viewList.setAdapter(adapter);
        setOnClickListener();
    }

    private void setOnClickListener() {
        listener = (v, position) -> {
           Intent intent = new Intent(getApplicationContext(),MallActivity.class);
           intent.putExtra("malls", (Serializable) malls_List);
           startActivity(intent);
        };
    }

    public void getCites() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, cities_json_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray citiesArray = obj.getJSONArray("cities");
                            malls_List = new ArrayList<>();
                            for (int i = 0; i < citiesArray.length(); i++) {
                                JSONObject data = citiesArray.getJSONObject(i);
                                City city = new City();
                                city.setId(Integer.parseInt(data.getString("id")));
                                city.setName(data.getString("name"));
                                JSONArray malls = citiesArray.getJSONObject(i).getJSONArray("malls");
                                Mall[] m = new Mall[malls.length()];
                                for(int y = 0 ; y < malls.length();y++){
                                    JSONObject mallsDATA = malls.getJSONObject(y);
                                    Mall mall = new Mall();
                                    mall.setId(Integer.parseInt(mallsDATA.getString("id")));
                                    mall.setName(mallsDATA.getString("name"));
                                    m[y] = mall;
                                    malls_List.add(mall);
                                    city.setMalls(m);
                                    JSONArray shops = mallsDATA.getJSONArray("shops");
                                    Shop[] s = new Shop[shops.length()];
                                    for(int j = 0 ; j < shops.length(); j++){
                                        JSONObject shopsData = shops.getJSONObject(y);
                                        Shop shop = new Shop();
                                        //shop.setId(Integer.parseInt(shopsData.getString("id")));
                                        //shop.setName(shopsData.getString(shopsData.optString("name")));
                                        s[j] = shop;
                                        shops_List.add(shop);
                                    }
                                    mall.setShops(s);
                                }
                                cities_List.add(city);
                            }
                            CityAdapter adapter = new CityAdapter(getApplicationContext(), cities_List,listener);
                            viewList.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}