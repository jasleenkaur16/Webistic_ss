package com.satdroid.webisticproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserSettings extends AppCompatActivity {
    private Switch darkModeSwitch;
    private TextView userLogout_tv;

//private FirebaseAuth auth_logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

     //   auth_logout=FirebaseAuth.getInstance();
//        userLogout_tv=findViewById(R.id.user_logout_btn);
//
//        userLogout_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(UserSettings.this,"Some error occured",Toast.LENGTH_SHORT).show();
//
//                //                FirebaseAuth.getInstance().signOut();
////                Intent intentLogout = new Intent(getApplicationContext(),LoginPage.class);
////                startActivity(intentLogout);
////                finish();
//            }
//        });
        if(new DarkModePrefManager(this).isNightMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        setContentView(R.layout.activity_user_settings);
        userLogout_tv=findViewById(R.id.user_logout_btn);

        userLogout_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserSettings.this,"Logout",Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent intentLogout = new Intent(getApplicationContext(),LoginPage.class);
                startActivity(intentLogout);
                finish();
            }
        });
        //function for enabling dark mode
        setDarkModeSwitch();


    }
    private void setDarkModeSwitch(){
        darkModeSwitch = findViewById(R.id.darkModeSwitch);
        darkModeSwitch.setChecked(new DarkModePrefManager(this).isNightMode());
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DarkModePrefManager darkModePrefManager = new DarkModePrefManager(UserSettings.this);
                darkModePrefManager.setDarkMode(!darkModePrefManager.isNightMode());
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
            }
        });
    }

}