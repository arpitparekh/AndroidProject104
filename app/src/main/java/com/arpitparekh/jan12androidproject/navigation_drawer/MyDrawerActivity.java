package com.arpitparekh.jan12androidproject.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityMyDrawerBinding;
import com.arpitparekh.jan12androidproject.databinding.MyToolbarBinding;
import com.google.android.material.navigation.NavigationView;

public class MyDrawerActivity extends AppCompatActivity {

    private ActivityMyDrawerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        // lock drawer on gesture
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        binding.toolbarLayout.toolbar.setNavigationOnClickListener(view -> {

            binding.drawerLayout.openDrawer(Gravity.LEFT);

        });

        binding.toolbarLayout.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;
            }
        });

        View view =  binding.navigationView.getHeaderView(0);

        ImageView iv = view.findViewById(R.id.ivProfile);

        iv.setOnClickListener(view1 -> {



        });


    }
}