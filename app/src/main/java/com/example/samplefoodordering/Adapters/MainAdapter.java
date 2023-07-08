package com.example.samplefoodordering.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samplefoodordering.DetailActivity;
import com.example.samplefoodordering.Models.MainModel;
import com.example.samplefoodordering.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        MainModel model = list.get(position);
        holder.foodname.setText(model.getFoodname());
        holder.imageView.setImageResource(model.getFoodImage());
        holder.orderprice.setText(model.getOrderprice());
        holder.discription.setText(model.getDiscription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("image",model.getFoodImage());
                intent.putExtra("name",model.getFoodname());
                intent.putExtra("price",model.getOrderprice());
                intent.putExtra("description",model.getDiscription());
                intent.putExtra("type",1);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView foodname,orderprice,discription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);
            foodname=itemView.findViewById(R.id.foodname);
            orderprice=itemView.findViewById(R.id.orderprice);
            discription=itemView.findViewById(R.id.discription);


        }


    }

}
