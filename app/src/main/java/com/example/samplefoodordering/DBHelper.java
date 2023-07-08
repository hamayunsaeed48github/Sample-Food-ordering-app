package com.example.samplefoodordering;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.samplefoodordering.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "Database.db";
    final static int VERSION = 1;
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement , " +
                        "name text, " +
                        "phone text, " +
                        "price int ," +
                        "image int ," +
                        "foodname text," +
                        "description text," +
                        "quantity int)"


        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" drop table if exists orders ");
        onCreate(sqLiteDatabase);

    }

    public boolean dbinsert(String name , String phone, int price, int image , String foodname , String description,int quantity){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("foodname",foodname);
        values.put("description",description);
        values.put("quantity",quantity);
        long id = database.insert("orders",null,values);

        if(id<0){
            return false;
        }else{
            return true;
        }


    }

    public ArrayList<OrderModel> getOrders(){
        ArrayList<OrderModel> oreders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price,quantity from orders",null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrderModel model = new OrderModel();
                model.setOrdernumber(cursor.getInt(0) + "");
                model.setOrdername(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setOprice(cursor.getInt(3)+ "");
                model.setQuantity(cursor.getInt(4)+"");
                oreders.add(model);
            }
        }
        cursor.close();
        database.close();
        return oreders;
    }

    public Cursor getOrderById(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id = " + id,null);

        if (cursor !=null)
            cursor.moveToFirst();


        return cursor;
    }

    public boolean dbupdate(String name ,String phone ,int price , int image , String description,String foodname , int quantity , int id){
        SQLiteDatabase database = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",description);
        values.put("quantity",quantity);

        long row =database.update("orders",values,"id="+id,null);
        if(row<0){
            return false;
        }else{
            return true;
        }
    }
    public int dbdelet(String id){
        SQLiteDatabase database = getReadableDatabase();
        return database.delete("orders","id="+id,null);
    }


}
