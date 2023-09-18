package com.example.covid_19mapanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_map_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MapActivity.class)));
        findViewById(R.id.show_table_button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TableActivity.class)));
    }
}