package com.example.samplefoodordering;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.TimeAnimator;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.samplefoodordering.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View plus = findViewById(R.id.plus);
        View minus = findViewById(R.id.minus);





        View order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this,OrderActivity.class));
            }
        });

        DBHelper dbHelper = new DBHelper(this);

        if(getIntent().getIntExtra("type",0)==1) {

            final int image = getIntent().getIntExtra("image", 0);
            final String name = getIntent().getStringExtra("name");
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String disc = getIntent().getStringExtra("description");

            binding.detailimage.setImageResource(image);
            binding.detailfood.setText(name);
            binding.dis.setText(disc);
            binding.detailprice.setText(String.format("%d", price));


            binding.ordernow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean isInserted = dbHelper.dbinsert(
                            binding.yourname.getText().toString(),
                            binding.number.getText().toString(),
                            Integer.parseInt(binding.detailprice.getText().toString()),
                            image,
                            name,
                            disc,
                            Integer.parseInt(binding.quantity.getText().toString())

                    );

                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Successfully Store", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                    startActivity(new Intent(DetailActivity.this,OrderActivity.class));

                }
            });

            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int currentQuantity = Integer.parseInt(binding.quantity.getText().toString());
                    int basePrice = Integer.parseInt(getIntent().getStringExtra("price"));

                    currentQuantity++;
                    int currentPrice = basePrice*currentQuantity;

                    binding.quantity.setText(String.valueOf(currentQuantity));
                    binding.detailprice.setText(String.valueOf(currentPrice));
                }
            });

            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int currentQuantity = Integer.parseInt(binding.quantity.getText().toString());
                    int basePrice = Integer.parseInt(getIntent().getStringExtra("price"));

                    if (currentQuantity > 1) {
                        currentQuantity--;
                        int currentPrice = currentQuantity * basePrice;

                        binding.quantity.setText(String.valueOf(currentQuantity));
                        binding.detailprice.setText(String.valueOf(currentPrice));
                    }
                }
            });


        }else{
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = dbHelper.getOrderById(id);

            int image = cursor.getInt(4);

            binding.detailimage.setImageResource(image);
            binding.detailfood.setText(cursor.getString(5));
            binding.dis.setText(cursor.getString(6));
            binding.detailprice.setText(String.format("%d", cursor.getInt(3)));
            binding.quantity.setText(String.format("%d",cursor.getInt(7)));

            binding.yourname.setText(cursor.getString(1));
            binding.number.setText(cursor.getString(2));


            binding.ordernow.setText("Update Now");
            binding.ordernow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isUpdate= dbHelper.dbupdate(
                            binding.yourname.getText().toString(),
                            binding.number.getText().toString(),
                            Integer.parseInt(binding.detailprice.getText().toString()),
                            image,
                            binding.dis.getText().toString(),
                            binding.detailfood.getText().toString(),
                            Integer.parseInt(binding.quantity.getText().toString()),
                            id);

                            if (isUpdate){
                        Toast.makeText(DetailActivity.this,"Updated successfully",Toast.LENGTH_SHORT).show();
                    }else{
                                Toast.makeText(DetailActivity.this,"Error",Toast.LENGTH_SHORT).show();
                    }
                    startActivity(new Intent(DetailActivity.this,OrderActivity.class));
                    plus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int currentQuantity = Integer.parseInt(binding.quantity.getText().toString());
                            int basePrice = Integer.parseInt(getIntent().getStringExtra("price"));

                            currentQuantity++;
                            int currentPrice = basePrice*currentQuantity;

                            binding.quantity.setText(String.valueOf(currentQuantity));
                            binding.detailprice.setText(String.valueOf(currentPrice));
                        }
                    });

                    minus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int currentQuantity = Integer.parseInt(binding.quantity.getText().toString());
                            int basePrice = Integer.parseInt(getIntent().getStringExtra("price"));

                            if (currentQuantity > 1) {
                                currentQuantity--;
                                int currentPrice = currentQuantity * basePrice;

                                binding.quantity.setText(String.valueOf(currentQuantity));
                                binding.detailprice.setText(String.valueOf(currentPrice));
                            }
                        }
                    });




                }


            });


        }




    }
}