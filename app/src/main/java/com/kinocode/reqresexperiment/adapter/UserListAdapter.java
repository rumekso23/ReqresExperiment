package com.kinocode.reqresexperiment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kinocode.reqresexperiment.R;
import com.kinocode.reqresexperiment.model.UserList;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private List<UserList.Datum> datum;
    private Context context;


    public UserListAdapter(Context context, List<UserList.Datum> datum) {
        this.datum = datum;
        this.context = context;

    }



    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_user, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserListAdapter.MyViewHolder viewHolder, int position) {
        UserList.Datum datums = datum.get(position);
        viewHolder.tvFirstname.setText(datums.getFirstName());
        viewHolder.tvLastname.setText(datums.getLastName());
        Glide.with(context)
                .load(datums.getAvatar())
                .into(viewHolder.imgAvatar);
    }


    @Override
    public int getItemCount() {
        return datum.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgAvatar;
        TextView tvFirstname, tvLastname;
        public MyViewHolder(View itemView) {
            super(itemView);

            imgAvatar = (ImageView) itemView.findViewById(R.id.img_avatar);
            tvFirstname = (TextView) itemView.findViewById(R.id.tv_firstname);
            tvLastname = (TextView) itemView.findViewById(R.id.tv_lastname);
        }
    }
}
