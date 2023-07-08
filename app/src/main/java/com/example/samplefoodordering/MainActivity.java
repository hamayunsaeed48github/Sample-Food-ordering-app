package com.example.samplefoodordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.samplefoodordering.Adapters.MainAdapter;
import com.example.samplefoodordering.Models.MainModel;
import com.example.samplefoodordering.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger1,"Zinger Burger","12","Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.burger2,"Chease Burger","15","A mouthwatering delight with a savory beef patty, oozy melted cheese, and irresistible flavors."));
        list.add(new MainModel(R.drawable.burger3,"Tower Burger","20","A meaty marvel stacked high with delicious layers of flavor."));
        list.add(new MainModel(R.drawable.burger4,"Super Deal","50","Double the delight with a lip-smacking duo of burgers, perfect for a hearty meal."));
        list.add(new MainModel(R.drawable.burger5,"3 in one","30","A flavor-packed trio of burgers, ensuring a delightful feast that will keep your cravings fully satisfied."));
        list.add(new MainModel(R.drawable.chicken,"Chicken","50","Versatile, lean, and packed with protein."));
        list.add(new MainModel(R.drawable.fajita,"Fajita","200","A flavorful combination of sizzling fajita-style toppings, melted cheese, and a crispy crust."));
        list.add(new MainModel(R.drawable.mutton,"Mutton","300"," Juicy and flavorful meat from mature sheep, perfect for hearty dishes and rich in traditional culinary heritage."));
        list.add(new MainModel(R.drawable.paratha,"Paratha","30"," A buttery and versatile flatbread, perfect for savoring on its own or pairing with a variety of dishes"));
        list.add(new MainModel(R.drawable.pizza,"Nawabi","500"," A regal twist on a classic favorite, where the flavors of Nawabi cuisine reign supreme atop a cheesy."));
        list.add(new MainModel(R.drawable.shami,"Anda shami","60"," A tantalizing minced meat patty, bursting with aromatic spices and a crispy exterior."));
        list.add(new MainModel(R.drawable.soap,"Chicken soap","150","A comforting elixir of chicken, crafted to soothe and nourish with every spoonful."));
        list.add(new MainModel(R.drawable.small_pizza,"Small Pizza","100","A delightful personal-sized treat, packed with all the flavors and goodness of a traditional pizza."));



        MainAdapter mainAdapter = new MainAdapter(list,this);
        binding.recyclerview.setAdapter(mainAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(linearLayoutManager);

        View order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
            }
        });




    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.items,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.order:
//                startActivity(new Intent(MainActivity.this,OrderActivity.class));
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}