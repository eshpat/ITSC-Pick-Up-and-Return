package com.example.itsc3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TVInventory extends AppCompatActivity {

    private CustomView customView;

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;

    private Button Back;
    private Button clear_button;
    private Button submit;
    private EditText initalsIn, initals, timeIn, timeOut, dateIn, dateOut, printName;
    private Spinner TVSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvinventory);

        setUpSpinner();
        setUpViews();
        initViews();
        loadedSavedPreferences();


        String initalsout = initals.getText().toString();
        String initialsIn = initals.getText().toString();
        String date1 = dateIn.getText().toString();
        String date2 = dateOut.getText().toString();
        String time1 = timeIn.getText().toString();
        String time2 = timeOut.getText().toString();
        String name = printName.getText().toString();


        // String inputText = sharedPreferences.getString("inputKey", "");
        clear_button = findViewById(R.id.clear_button);
        clear_button.setOnClickListener(v -> customView.clearSignature());


        submit = findViewById(R.id.submit);
        submit.setOnClickListener(v -> {
            saveData();
            clearPreferences();
            String selectedItem = TVSpinner.getSelectedItem().toString();
            DataManager.getInstance().getFormData().setSelectedItem(selectedItem);
            checkPermissionAndCreateFile();
            Toast.makeText(getApplicationContext(), "Submission successful!", Toast.LENGTH_SHORT).show();
        });



        final ScrollView scrollView = findViewById(R.id.your_scrollview_id); // make sure to add an id to your ScrollView in XML
        View signatureBox = findViewById(R.id.Signature_Pad); // your signature box view

        signatureBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        scrollView.requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        scrollView.requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });




    }

    private void initViews() {
        initals = findViewById(R.id.Initals);
        initalsIn = findViewById(R.id.InitalsIn);
        dateIn = findViewById(R.id.DateIn);
        dateOut = findViewById(R.id.DateEnter);
        timeIn = findViewById(R.id.TimeIn);
        timeOut = findViewById(R.id.TimeEnter);
        printName = findViewById(R.id.EnterName);
        customView = findViewById(R.id.Signature_Pad);
        TVSpinner = findViewById(R.id.TVSpinner);

    }

    private void checkPermissionAndCreateFile() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            } else {
                createCSVFile(); // Permission is already granted, proceed to create the file
            }
        } else {
            createCSVFile(); // Pre-Marshmallow, permissions granted at installation
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                createCSVFile(); // Permission was granted
            } else {
                Toast.makeText(this, "Permission Accepted to write to storage", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void createCSVFile() {
        Log.d("CSV Creation", "Attempting to create CSV file...");
        File csvDirectory = new File(getExternalFilesDir(null), "CSVFiles");
        if (!csvDirectory.exists() && !csvDirectory.mkdirs()) {
            Log.e("CSV Creation", "Failed to create directory");
            return;
        }

        File csvFile = new File(csvDirectory, "EquipmentRequests.csv");

        try (FileWriter writer = new FileWriter(csvFile, true)){
            writer.append(String.format("%s, %s, %s, %s, %s, %s, %s\n",
                    initals.getText().toString(),
                    initalsIn.getText().toString(),
                    dateIn.getText().toString(),
                    dateOut.getText().toString(),
                    timeIn.getText().toString(),
                    timeOut.getText().toString(),
                    TVSpinner.getSelectedItem().toString()));
            writer.flush();
            Log.d("CSV Creation", "CSV file created successfully at " + csvFile.getAbsolutePath());
            clearForm();
        } catch (IOException e){
            Toast.makeText(getApplicationContext(), "Error writing CSV file", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void clearForm() {
        initals.setText("");
        initalsIn.setText("");
        dateIn.setText("");
        dateOut.setText("");
        timeIn.setText("");
        timeOut.setText("");
        printName.setText("");
        customView.clearSignature();
        TVSpinner.setSelection(0);
        clearPreferences();
    }

    private void clearPreferences() {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        prefs.edit().clear().apply();  // Clear all temporary saved data
    }

    private void saveData() {

        clearPreferences();
    }

    private void setUpViews() {
        Back = (Button) findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePreferences();
                finish();
                Intent intent = new Intent(TVInventory.this, MenuActivity.class);
                startActivity(intent);
            }

        });
    }

    private void savePreferences() {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("initals", initals.getText().toString());
        // Repeat for other form fields...
        editor.apply();
    }

    private void saveSignature(){
        customView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(customView.getDrawingCache());
        customView.setDrawingCacheEnabled(false);

        try {
            String filename = "signature.png";
            FileOutputStream stream = this.openFileOutput(filename, Context.MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

            stream.close();
            bitmap.recycle();

            SharedPreferences perfs = getSharedPreferences("MyPerfs", MODE_PRIVATE);
            SharedPreferences.Editor editor = perfs.edit();
            editor.putString("SignaurePath", filename);
            editor.apply();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadSignature(){
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String filePath = prefs.getString("SignaturePath", "");
        if (!filePath.isEmpty()){
            try {
                FileInputStream stream = this.openFileInput(filePath);
                Bitmap bitmap = BitmapFactory.decodeStream(stream);
                customView.setSignatureBitmap(bitmap);

            } catch (Exception e){
                e.printStackTrace();
            }
        }else {
            Log.e("loadSignature", "File does not exist:" + filePath);
        }
    }


    private void loadedSavedPreferences() {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        initals.setText(prefs.getString("initals", ""));
        dateOut.setText(prefs.getString("Date Out", ""));
        dateIn.setText(prefs.getString("Date In", ""));
        printName.setText(prefs.getString("Print Name", ""));
        initalsIn.setText(prefs.getString("Initials in", ""));
        timeIn.setText(prefs.getString("Time in", ""));
        timeOut.setText(prefs.getString("Time Out", ""));
        int spinnerPosition = prefs.getInt("SpinnerSelection", 0);
        TVSpinner.setSelection(spinnerPosition);
    }

    private void setUpSpinner() {

        List<String> tv = new ArrayList<String>();
        tv.add("TV-01");
        tv.add("TV-02");
        tv.add("TV-03");
        tv.add("TV-05");
        tv.add("TV-09");



        ArrayAdapter<String> adapter = new ArrayAdapter<>(TVInventory.this, android.R.layout.simple_list_item_1, tv);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        Spinner TVSpinner = findViewById(R.id.TVSpinner);
        TVSpinner.setAdapter(adapter);

        TVSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = tv.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }

}