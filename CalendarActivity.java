package com.example.itsc3;

import androidx.appcompat.app.AppCompatActivity;
import com.example.itsc3.Calendar;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class CalendarActivity extends AppCompatActivity {


    Button menuButton;


    private ListView EquipmentListView;
    private List<String> formTitles;


    public static ArrayList<String> equipmentList = new ArrayList<>();
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //EquipmentListView equipmentListView = findViewById(R.id.EquipmentListView);
        ListView listView = findViewById(R.id.EquipmentListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, equipmentList);
        listView.setAdapter(adapter);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String equipmentName = extras.getString("EQUIPMENT_NAME");
            if (equipmentName != null){
                equipmentList.add(equipmentName);
                adapter.notifyDataSetChanged();
            }
        }




        menuButton =(Button) findViewById(R.id.menuButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CalendarActivity.this, MenuActivity.class);
                startActivity(intent);

                Log.d("CalendarActivity", "Menu button clicked");


            }
        });


        /*Button menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                Intent intent = new Intent(CalendarActivity.this, Menu.class);
                startActivity(intent);
            } catch (Exception e) {
                Log.e("CalendarActivity", "Error starting Menu activity", e);
            }


                Log.d("CalendarActivity", "Activity started");*/


       /* if (findViewById(R.id.DocumentCamera) != null) {
            if (savedInstanceState != null) {
                return;
            }

            Calendar calendarFragment = new Calendar();
            calendarFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.DocumentCamera, calendarFragment).commit();


        }
    }*/
    }
}
/*
        });
    }
}*/
