package com.example.samplefoodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.samplefoodordering.Adapters.OrderAdapter;
import com.example.samplefoodordering.Models.OrderModel;
import com.example.samplefoodordering.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);

        ArrayList<OrderModel>list = helper.getOrders();

//        list.add(new orderModel(R.drawable.burger1,"Zinger Burger","123456987","10"));
//        list.add(new orderModel(R.drawable.burger1,"Zinger Burger","123456987","10"));
//        list.add(new orderModel(R.drawable.burger1,"Zinger Burger","123456987","10"));
//        list.add(new orderModel(R.drawable.burger1,"Zinger Burger","123456987","10"));
//        list.add(new orderModel(R.drawable.burger1,"Zinger Burger","123456987","10"));
//        list.add(new orderModel(R.drawable.burger1,"Zinger Burger","123456987","10"));


        OrderAdapter orderAdapter = new OrderAdapter(list,this);
        binding.orderrecylerview.setAdapter(orderAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderrecylerview.setLayoutManager(layoutManager);
    }
}