package com.codewithdeva.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

        BottomNavigationView bottomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomView = findViewById(R.id.bottom_nav);

        bottomView.setOnNavigationItemSelectedListener(navListener);
    }
       private BottomNavigationView.OnNavigationItemSelectedListener navListener=
               new BottomNavigationView.OnNavigationItemSelectedListener() {
                   @Override
                   public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                       Fragment selectedFragment=null;

                       switch(item.getItemId())
                       {
                           case R.id.home:
                               selectedFragment=new HomeFragment();
                               break;

                           case R.id.favorite:
                               selectedFragment=new FavoriteFragment();
                               break;

                           case R.id.search:
                               selectedFragment=new SearchFragment();
                               break;

                       }
                      FragmentManager fm=getSupportFragmentManager();
                       fm.beginTransaction().replace(R.id.fragment_container,selectedFragment).addToBackStack(null).commit();

                       return true;

                   }
               };

}