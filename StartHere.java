package com.example.itsc3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartHere extends AppCompatActivity {


    public void testing(View view) {
        //Log.d("StartHere", "Button clicked" + button.isEnabled());
        Button b = (Button) view;
        //b.setText("hello");


        Intent intent = new Intent(StartHere.this, CalendarActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_here);




       /* Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {*/



    }
}