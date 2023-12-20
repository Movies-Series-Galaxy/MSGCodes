package com.msg.msgalaxy;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.msg.msgalaxy.fragments.HomeFragment;
import com.msg.msgalaxy.fragments.ProfileFragment;
import com.msg.msgalaxy.fragments.SearchFragment;
import com.msg.msgalaxy.fragments.TopRatedFragment;

import me.ibrahimsn.lib.NiceBottomBar;
import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    private NiceBottomBar bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bottomNavigationView = (NiceBottomBar) findViewById(R.id.bottomNavigationId);

        //Default Fragment is (HOME fragment)
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerId, new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelect(int i) {
                Fragment selectedFragment = null;
                switch (i) {
                    case 0:
                        selectedFragment = new HomeFragment();
                        break;
                    case 1:
                        selectedFragment = new SearchFragment();
                        break;
                    case 2:
                        selectedFragment = new TopRatedFragment();
                        break;
                    case 3:
                        selectedFragment = new ProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containerId, selectedFragment).commit();
            }
        });

    }
}