package com.example.taskplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class LandingActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        bottomNav = findViewById(R.id.bottom_nav);

        replaceFragment(new HomeFragment());

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home_menu:
                    replaceFragment(new HomeFragment());
                    return true;
                case R.id.favourite_menu:
                    replaceFragment(new FavouriteFragment());
                    return true;
                case R.id.completed_menu:
                    replaceFragment(new CompletedFragment());
                    return true;
            }
            return false;
        });
    }

    public void replaceFragment (Fragment  fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.commit();
    }
}