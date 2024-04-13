package com.satdroid.webisticproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    private FirebaseAuth authMain;
    private FirebaseUser user_current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authMain =FirebaseAuth.getInstance();
        user_current= authMain.getCurrentUser();
        if(user_current==null){
            Intent intentMain = new Intent(getApplicationContext(),LoginPage.class);
            startActivity(intentMain);
            finish();
        }

        bottomNavigation=findViewById(R.id.bottom_navigation);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frame_layout, new HomeFragment());
        transaction.commit();

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int menu_id=item.getItemId();
                if(menu_id==R.id.explore_menu)
                {
                    replaceFrag(new ExploreFragment());
                    return true;
                }
                else if(menu_id==R.id.create_menu)
                {
                    replaceFrag(new CreateFragment());
                    return true;
                }
                else if(menu_id==R.id.notification_menu)
                {
                    replaceFrag(new NotificationFragment());
                    return true;
                }
                else if(menu_id==R.id.home_menu)
                {
                    replaceFrag(new HomeFragment());
                    return true;
                }else if(menu_id==R.id.profile_menu)
                {
                    replaceFrag(new Profilefragment());
                    return true;
                }
                return true;
            }
        });
    }

    private void replaceFrag(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }
}