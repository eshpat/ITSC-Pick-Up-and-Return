package com.example.itsc3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Document;

import java.io.File;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Forms extends AppCompatActivity  {


    EditText DateIn, TimeIn, InitialsIn, Signature, Initials, TimeEnter, DateEnter, EnterName;
    Button submit;
    String text;

    Button Back;
    String [] adapters = {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);
        DateIn = findViewById(R.id.DateIn);
        TimeIn = findViewById(R.id.TimeIn);
        InitialsIn = findViewById(R.id.InitalsIn);
        Signature = findViewById(R.id.Signature);
        Initials = findViewById(R.id.Initals);
        TimeEnter = findViewById(R.id.TimeEnter);
        DateEnter = findViewById(R.id.DateEnter);
        EnterName = findViewById(R.id.EnterName);

       // Spinner






        Back =(Button) findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Forms.this, MenuActivity.class);
                startActivity(intent);

            }
        });


       /* submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               text = DateIn.getText().toString().trim();
               if (text.isEmpty()){
                   Toast.makeText(Forms.this, "Please enter information to continue", Toast.LENGTH_SHORT).show();
               }else{
                   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                       if (checkSelfPermission(Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION) ==
                       PackageManager.PERMISSION_GRANTED){
                           String [] permissions = {Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION};
                           
                       }
                   }
               }
            }*/
    }//);
}

   /* @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }


}
*/
  /*  private void createPDF(String DateIn, String TimeIn, String InitialsIn, String Signature, String Initials, String TimeEnter, String DateEnter, String EnterName) throws FileLockInterruptionException{
        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath, "itsc checkout.pdf");

        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDocument = new PdfDocument();
        Document document = new Document(pdfDocument);

        document.close();
        Toast.makeText(this, "PDF Created", Toast.LENGTH_LONG).show();

    }*/
//}