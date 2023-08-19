package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ZelaActivity extends AppCompatActivity {


    GridView gridViewZela;
    HashMap<String,String> hashMap = new HashMap<>();
    static ArrayList<HashMap<String,String>> zelaArrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zela);


        gridViewZela = findViewById(R.id.gridViewZela);


        MyAdapter myAdapter = new MyAdapter();
        gridViewZela.setAdapter(myAdapter);




    }
    //=========================== Writing my class code ===================

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return zelaArrayList.size();
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




            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View zelaView = inflater.inflate(R.layout.item_zela, viewGroup, false);

            ImageView zelaCoverItem = zelaView.findViewById(R.id.zelaCoverItem);
            TextView zelaNameItem = zelaView.findViewById(R.id.zelaNameItem);
            LinearLayout layDistrict = zelaView.findViewById(R.id.layDistrict);


            HashMap<String,String> hashMap = zelaArrayList.get(i);
            String zela_image = hashMap.get("zela_image");
            String zela_name = hashMap.get("zela_name");




            zelaCoverItem.setImageResource(Integer.parseInt(zela_image));
            zelaNameItem.setText(zela_name);



            //=========================================
            
            layDistrict.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    assert zela_name != null;
                    if (zela_name.contains("Dhaka")){

                        thana_dhaka();
                    } else if (zela_name.contains("Faridpur")) {
                        thana_faridpur();

                    } else if (zela_name.contains("Chattogram")) {

                        thana_chattagram();

                    } else if (zela_name.contains("Khulna")) {
                        thana_khulna();

                    }else if (zela_name.contains("Bagerhat")) {
                        thana_bagerhat();

                    }else if (zela_name.contains("Sylhet")) {
                        thana_sylhet();

                    }

                    Intent intent = new Intent(ZelaActivity.this, PoliceNumberActivity.class);
                    startActivity(intent);

                }
            });

            return zelaView;
        }
    }


    //=========================== writing my Function ===============

    //==================================================
   



    public void thana_dhaka(){
        zelaArrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("thana_name","Uttara");
        hashMap.put("thana_cover", String.valueOf(R.drawable.dhaka));
        zelaArrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("thana_name","Uttara");
        hashMap.put("thana_cover", String.valueOf(R.drawable.dhaka));
        zelaArrayList.add(hashMap);

        PoliceNumberActivity.thanaArrayList = zelaArrayList;
    }


    public void thana_faridpur(){
        zelaArrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("thana_name","Faridpur Bazar");
        hashMap.put("thana_cover", String.valueOf(R.drawable.dhaka));
        zelaArrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("thana_name","Babu Bazar");
        hashMap.put("thana_cover", String.valueOf(R.drawable.dhaka));
        zelaArrayList.add(hashMap);

        PoliceNumberActivity.thanaArrayList = zelaArrayList;
    }


    public void thana_chattagram(){
        zelaArrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("thana_name","Coxbazar");
        hashMap.put("thana_cover", String.valueOf(R.drawable.chittagong));
        zelaArrayList.add(hashMap);

        PoliceNumberActivity.thanaArrayList = zelaArrayList;


    }


    public void thana_khulna(){
        zelaArrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("thana_name","Khulna 1");
        hashMap.put("thana_cover", String.valueOf(R.drawable.khulna));
        zelaArrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("thana_name","Khulna 2");
        hashMap.put("thana_cover", String.valueOf(R.drawable.khulna));
        zelaArrayList.add(hashMap);

        PoliceNumberActivity.thanaArrayList = zelaArrayList;
    }

    public void thana_bagerhat(){
        zelaArrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("thana_name","Bagerhat 1");
        hashMap.put("thana_cover", String.valueOf(R.drawable.khulna));
        zelaArrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("thana_name","Bagerhat 2");
        hashMap.put("thana_cover", String.valueOf(R.drawable.khulna));
        zelaArrayList.add(hashMap);

        PoliceNumberActivity.thanaArrayList = zelaArrayList;

    }


    public void thana_sylhet(){
        zelaArrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("thana_name","sylhet");
        hashMap.put("thana_cover", String.valueOf(R.drawable.sylhet));
        zelaArrayList.add(hashMap);

        PoliceNumberActivity.thanaArrayList = zelaArrayList;


    }



}