package com.example.samplefoodordering.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samplefoodordering.DBHelper;
import com.example.samplefoodordering.DetailActivity;
import com.example.samplefoodordering.Models.OrderModel;
import com.example.samplefoodordering.OrderActivity;
import com.example.samplefoodordering.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    ArrayList<OrderModel> list;
    Context context;

    public OrderAdapter(ArrayList<OrderModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_order,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final OrderModel order = list.get(position);
        holder.orderimage.setImageResource(order.getOrderimage());
        holder.orderName.setText(order.getOrdername());
        holder.OrderNumber.setText(order.getOrdernumber());
        holder.Oprice.setText(order.getOprice());
        holder.quantity1.setText(order.getQuantity());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("id",Integer.parseInt(order.getOrdernumber()));
                intent.putExtra("type",2);

                context.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Item")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setMessage("Are you sure to delete this item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DBHelper dbHelper = new DBHelper(context);
                                if(dbHelper.dbdelet(order.getOrdernumber())>0){
                                    Toast.makeText(context, "delet", Toast.LENGTH_SHORT).show();
                                    list.remove(position);
                                    notifyItemRemoved(position);

                                }else{
                                    Toast.makeText(context, "no delet", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView orderimage;
        TextView orderName,OrderNumber,Oprice,quantity1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderimage = itemView.findViewById(R.id.orderimage);
            orderName=itemView.findViewById(R.id.ordername);
            OrderNumber=itemView.findViewById(R.id.ordernumber);
            Oprice=itemView.findViewById(R.id.oprice);
            quantity1=itemView.findViewById(R.id.quantity1);
        }
    }
}
