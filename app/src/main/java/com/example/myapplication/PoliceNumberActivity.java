package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

public class PoliceNumberActivity extends AppCompatActivity {

    GridView gridViewThana;
    HashMap<String,String> hashMap = new HashMap<>();
    static ArrayList<HashMap<String,String>> thanaArrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_number);

        gridViewThana.findViewById(R.id.gridViewThana);
        MyAdapter myAdapter = new MyAdapter();
        gridViewThana.setAdapter(myAdapter);

    }

    // ========================================================


    public class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return thanaArrayList.size();
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
            View myView = inflater.inflate(R.layout.item_call,viewGroup,false);

            ImageView thanaCover = myView.findViewById(R.id.thanaCover);
            TextView thanaTitle = myView.findViewById(R.id.thanaTitle);



            HashMap<String,String> hashMap = thanaArrayList.get(i);
            String thana_name = hashMap.get("thana_name");
            String thana_cover = hashMap.get("thana_cover");


            thanaCover.setImageResource(Integer.parseInt(thana_cover));
            thanaTitle.setText(thana_name);




            return myView;
        }
    }









    // ========================================================

}