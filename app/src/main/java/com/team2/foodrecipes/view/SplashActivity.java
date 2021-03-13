
package com.team2.foodrecipes.view;

import androidx.appcompat.app.AppCompatActivity;

import com.team2.foodrecipes.view.home.HomeActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // langsung pindah ke MainActivity atau activity lain 
        // begitu memasuki splash screen ini
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}