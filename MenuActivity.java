package com.example.itsc3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.itsc3.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMenuBinding binding;

    ImageButton Adaptors;
    ImageButton Cables;
    ImageButton Laptops;
    ImageButton PresentationRemote;
    ImageButton DVDPlayer;
    ImageButton FlipChart;
    ImageButton SoundSystem;
    ImageButton Projecter;
    ImageButton Screen;
    ImageButton DocumentCamera;
    ImageButton TV;

    Button backtoMenu;





    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      /*  backtoMenu = (Button) findViewById(R.id.backtoMenu);
        backtoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(MenuActivity.this, CalendarActivity.class);
                startActivity(intent);
            }

        });
*/
        Adaptors = (ImageButton) findViewById(R.id.Adaptors);
        Adaptors.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, AdapterInventory.class);
            startActivity(intent);
        });

        Cables = (ImageButton) findViewById(R.id.Cables);
        Cables.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, CablesInventory.class);
            startActivity(intent);
        });

        Laptops = (ImageButton) findViewById(R.id.Laptops);
        Laptops.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, LaptopInventory.class);
            startActivity(intent);
        });

        PresentationRemote = (ImageButton) findViewById(R.id.PresentationRemote);
        PresentationRemote.setOnClickListener(v ->{
            Intent intent = new Intent (MenuActivity.this, RemoteInventory.class);
            startActivity(intent);
        });


        DVDPlayer = (ImageButton) findViewById(R.id.DVDPlayer);
        DVDPlayer.setOnClickListener(v ->{
            Intent intent = new Intent (MenuActivity.this, DVDInventory.class);
            startActivity(intent);
        });

        FlipChart = (ImageButton) findViewById(R.id.FlipChart);
        FlipChart.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, FlipChartInventory.class);
            startActivity(intent);
        });

        SoundSystem = (ImageButton) findViewById(R.id.SoundSystem);
        SoundSystem.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, SoundSystemInventory.class);
            startActivity(intent);
        });

        Projecter = (ImageButton) findViewById(R.id.Projecter);
        Projecter.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ProjecterInventory.class);
            startActivity(intent);
        });

        Screen = (ImageButton) findViewById(R.id.Screen);
        Screen.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ScreenInventory.class);
            startActivity(intent);
        });

        DocumentCamera = (ImageButton) findViewById(R.id.DocumentCamera);
        DocumentCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, DocumentCameraInventory.class);
            startActivity(intent);
        });

        TV = (ImageButton) findViewById(R.id.TV);
        TV.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, TVInventory.class);
            startActivity(intent);
        });










        button = findViewById(R.id.BlankForm);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, FormSignature.class);
                startActivity(intent);


                //TextView tv = findViewById(R.id.textView2);
                //tv.setText("hello");
                Fragment fragment = new Fragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.start,fragment).commit();
            }


            public void testing(View view) {
                                          // Your code to execute when the ImageButton is clicked
            }
        });




                //setSupportActionBar(binding.toolbar);

       /* NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
*/
      /*  binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });*/
    }


/*    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();*/
    }


