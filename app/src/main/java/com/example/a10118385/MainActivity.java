package com.example.a10118385;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //Tanggal   :04 Juni 2021
    //NIM       :10118385
    //Nama      :Julian Arisky Lase
    //Kelas     :IF9

    BottomNavigationView bottomNavigationView;
    Fragment f;

    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected( MenuItem item) {
            f = null;
            switch (item.getItemId()){
                case R.id.menu_profile:
                    f = new FragmentProfile();
                    break;
                case R.id.menu_diary:
                    f = new FragmentDiary();
                    break;
                case R.id.menu_info:
                    f = new FragmentInfo();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,f).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.button_navigation_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
        f = new FragmentProfile();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,f).commit();

    }
}