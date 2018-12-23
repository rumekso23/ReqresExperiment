package com.kinocode.reqresexperiment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kinocode.reqresexperiment.R;
import com.kinocode.reqresexperiment.model.MultipleResources;

import java.util.List;

public class MultipleResourceAdapter extends RecyclerView.Adapter<MultipleResourceAdapter.MyViewHolder>{

    private List<MultipleResources.Datum> listResources;
    private Context context;

    public MultipleResourceAdapter(Context applicationContext, List<MultipleResources.Datum> listResources) {
        this.context = applicationContext;
        this.listResources = listResources;
    }



    @Override
    public MultipleResourceAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_resource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MultipleResourceAdapter.MyViewHolder myViewHolder, int position) {
        MultipleResources.Datum resources = listResources.get(position);
        myViewHolder.imgColor.setBackgroundColor(Color.parseColor(resources.getColor()));
        myViewHolder.tvName.setText(resources.getName());
        myViewHolder.tvYear.setText(resources.getYear());
        myViewHolder.tvColorCode.setText(resources.getColor());
    }

    @Override
    public int getItemCount() {
        return listResources.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgColor;
        TextView tvName, tvYear, tvColorCode;
        public MyViewHolder( View itemView) {
            super(itemView);

            imgColor = itemView.findViewById(R.id.img_color);
            tvName = itemView.findViewById(R.id.tv_name);
            tvYear = itemView.findViewById(R.id.tv_year);
            tvColorCode = itemView.findViewById(R.id.tv_color_code);
        }
    }
}
