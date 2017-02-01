package com.example.cbluser22.testapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.cbluser22.testapp.adapter.RecycleAdapter;
import com.example.cbluser22.testapp.model.HomeCardModel;
import com.example.cbluser22.testapp.R;

import java.util.ArrayList;

/**
 * Created by cbluser22 on 30/1/17.
 */

public class HomeCardActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<HomeCardModel> list=new ArrayList<>();
    Toolbar toolbarHome;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homecard);


        init();
        setToolBar();
        getData();

    }

    private void setToolBar() {


        setSupportActionBar(toolbarHome);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public void getData()
    {
        list.add(new HomeCardModel("adidas",R.drawable.logo_adidas));
        list.add(new HomeCardModel("albertson",R.drawable.logo_albertsons));
        list.add(new HomeCardModel("aerie",R.drawable.logo_aerie));
        list.add(new HomeCardModel("Abercombie & Fitch",R.drawable.logo_af));
        list.add(new HomeCardModel("Alamo DraftHouse",R.drawable.logo_alamo));


        RecycleAdapter recycleAdapter=new RecycleAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recycleAdapter);

    }
    public void init()
    {
        toolbarHome=(Toolbar) findViewById(R.id.toolbar_h);
        recyclerView=(RecyclerView)findViewById(R.id.rv_recyclerview);
    }
}
