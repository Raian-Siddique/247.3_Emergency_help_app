package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ImageView callIcon;
    HashMap<String,String> hashMap = new HashMap<>();
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        gridView = findViewById(R.id.gridView);
        callIcon = findViewById(R.id.callIcon);

        // Create table
        createTable();

        // Set adapter for grid view
        MyAdapter myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);



        // Set click listener for call icon
        callIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "999";

                // Create intent to dial phone number
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);


            }
        });



        //=======================================================================================


    }

    //============================   My Function Starts Here ===================

    // Custom adapter for grid view
    public class MyAdapter extends BaseAdapter {

      @Override
      public int getCount() {
          return arrayList.size();
      }

      @Override
      public Object getItem(int i) {
          return null;
      }

      @Override
      public long getItemId(int i) {
          return 0;
      }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {


            // Inflate item_district layout
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = inflater.inflate(R.layout.item_district, viewGroup, false);

            // Initialize views in item_district layout
            ImageView districtCover_item = myView.findViewById(R.id.districtCover_item);
            TextView districtName_item = myView.findViewById(R.id.districtName_item);
            LinearLayout layDistrict = myView.findViewById(R.id.layDistrict);

            // Get data from array list
            HashMap<String, String> hashMap = arrayList.get(i);
            String district_img = hashMap.get("district_img");
            String district_name = hashMap.get("district_name");

            // Set image resource and text
            districtCover_item.setImageResource(Integer.parseInt(district_img));
            districtName_item.setText(district_name);

            // Set random background color for district name
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            districtName_item.setBackgroundColor(color);

                     //------------------------------------------------------------------------

         layDistrict.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 if (district_name.contains("Dhaka")){

                     zela_dhaka();
                 } else if (district_name.contains("Chittagong")) {
                     zela_chittagong();

                 } else if (district_name.contains("Khulna")) {

                     zela_khulna();

                 } else if (district_name.contains("Sylhet")) {
                     zela_sylhet();

                 }

                 Intent intent = new Intent(MainActivity.this, ZelaActivity.class);
                 startActivity(intent);


             }
         });

                    //--------------------------------------------------------------------

          return myView;
      }
  }



  //===============================================================================

    // Create HashMap table for state list for Bangladesh
    public void createTable() {

        arrayList = new ArrayList<>();


        hashMap = new HashMap<>();
        hashMap.put("district_img", String.valueOf(R.drawable.dhaka));
        hashMap.put("district_name", "Dhaka");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("district_img", String.valueOf(R.drawable.chittagong));
        hashMap.put("district_name", "Chittagong");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("district_img", String.valueOf(R.drawable.khulna));
        hashMap.put("district_name", "Khulna");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("district_img", String.valueOf(R.drawable.sylhet));
        hashMap.put("district_name", "Sylhet");
        arrayList.add(hashMap);



    }


    //===============================================================================

    public void zela_dhaka(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("zela_image", String.valueOf(R.drawable.dhaka));
        hashMap.put("zela_name","Dhaka");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("zela_image", String.valueOf(R.drawable.dhaka));
        hashMap.put("zela_name","Faridpur");
        arrayList.add(hashMap);

//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.dhaka));
//        hashMap.put("zela_name","Gazipur");
//        arrayList.add(hashMap);

//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.dhaka));
//        hashMap.put("zela_name","Gopalganj");
//        arrayList.add(hashMap);
//
//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.dhaka));
//        hashMap.put("zela_name","Madaripur");
//        arrayList.add(hashMap);
//
//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.dhaka));
//        hashMap.put("zela_name","Manikganj");
//        arrayList.add(hashMap);

        ZelaActivity.zelaArrayList = arrayList;



    }



    //=================================================================

    public void zela_chittagong(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("zela_image", String.valueOf(R.drawable.chittagong));
        hashMap.put("zela_name","Chattogram");
        arrayList.add(hashMap);

//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.chittagong));
//        hashMap.put("zela_name","Brahmanbaria");
//        arrayList.add(hashMap);

//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.chittagong));
//        hashMap.put("zela_name","Chandpur");
//        arrayList.add(hashMap);
//
//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.chittagong));
//        hashMap.put("zela_name","Khagrachari");
//        arrayList.add(hashMap);
//
//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.chittagong));
//        hashMap.put("zela_name","Lakshmipur");
//        arrayList.add(hashMap);
//
//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.chittagong));
//        hashMap.put("zela_name","Noakhali");
//        arrayList.add(hashMap);

        ZelaActivity.zelaArrayList = arrayList;




    }

    //=================================================================

    public void zela_khulna(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("zela_image", String.valueOf(R.drawable.khulna));
        hashMap.put("zela_name","Khulna");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("zela_image", String.valueOf(R.drawable.khulna));
        hashMap.put("zela_name","Bagerhat");
        arrayList.add(hashMap);

//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.khulna));
//        hashMap.put("zela_name","Chuadanga");
//        arrayList.add(hashMap);
//
//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.khulna));
//        hashMap.put("zela_name","Jhenaidah");
//        arrayList.add(hashMap);
//
//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.khulna));
//        hashMap.put("zela_name","Kushtia");
//        arrayList.add(hashMap);
//
//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.khulna));
//        hashMap.put("zela_name","Magura");
//        arrayList.add(hashMap);

        ZelaActivity.zelaArrayList = arrayList;



    }
    //=================================================================

    public void zela_sylhet(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("zela_image", String.valueOf(R.drawable.sylhet));
        hashMap.put("zela_name","Sylhet");
        arrayList.add(hashMap);

//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.sylhet));
//        hashMap.put("zela_name","Moulvibazar");
//        arrayList.add(hashMap);

//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.sylhet));
//        hashMap.put("zela_name","Habiganj");
//        arrayList.add(hashMap);
//
//        hashMap = new HashMap<>();
//        hashMap.put("zela_image", String.valueOf(R.drawable.sylhet));
//        hashMap.put("zela_name","Sunamganj");
//        arrayList.add(hashMap);


        ZelaActivity.zelaArrayList = arrayList;

    }

    //=================================================================
    //=================================================================
}