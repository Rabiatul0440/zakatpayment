package com.example.zakatpayment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Calculate Button
        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityCalculate.class);
            startActivity(intent);
        });

        // Learn More About Zakat Button
        Button learnMoreButton = findViewById(R.id.learnMoreButton);
        learnMoreButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityInfo.class);
            startActivity(intent);
        });

        // About Developer Button
        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
            startActivity(intent);
        });
    }
}