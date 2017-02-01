package com.example.cbluser22.testapp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cbluser22.testapp.model.HomeCardModel;
import com.example.cbluser22.testapp.R;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by cbluser22 on 30/1/17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder> {

    private Activity activity;
    private List<HomeCardModel> mList=new ArrayList<>();

    public RecycleAdapter(Activity activity, List<HomeCardModel> mList)
    {
        this.activity=activity;
        this.mList=mList;
    }

    @Override
    public RecycleAdapter.RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecycleViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.RecycleViewHolder holder, int position) {
        holder.textView.setText(mList.get(position).desc);
        holder.imageView.setImageResource(mList.get(position).image);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private  TextView textView;
        public RecycleViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.tv_description1);
            imageView=(ImageView) itemView.findViewById(R.id.iv_image1);
        }
    }
}
