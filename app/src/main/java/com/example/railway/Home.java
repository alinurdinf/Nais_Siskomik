package com.example.railway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


//        NavHostFragment navHostFragment = getFragmentManager.findFragmentById(R.id.navigation_home);
//        NavController navController = navHostFragment.getNavController();
//        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
//        NavigationUI.setupWithNavController(bottomNav, navController);

//        AppBarConfiguration appBarConfiguration =
//                new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_ticket, R.id.navigation_profile).build();

//        new appBarConfiguration = AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_ticket, R.id.navigation_profile
//        ).build()
    }
}