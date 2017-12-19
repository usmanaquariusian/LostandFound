package com.example.usmanahmed.lostandfound;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Usman Ahmed on 22/11/2017.
 */

public class MyView extends RecyclerView.Adapter<MyView.ViewHolder>
{
    ArrayList<Model> arrayList;
    MyView(ArrayList<Model> list)
    {
        arrayList=list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.id.setText(arrayList.get(position).getEmail());
        holder.username.setText(arrayList.get(position).getUsername());
        holder.password.setText(arrayList.get(position).getPassword());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView username;
        TextView password;

        public ViewHolder(View itemView) {
            super(itemView);
            id=(TextView) itemView.findViewById(R.id.text1);
            username=(TextView) itemView.findViewById(R.id.text2);
            password=(TextView) itemView.findViewById(R.id.text3);
        }
    }
}
