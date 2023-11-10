package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import database.Car;
import database.DatabaseHelper;

public class AboutCarActivity extends AppCompatActivity {

	ImageView imageView;
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_car);
		Toolbar toolbar = findViewById(R.id.toolBar);
		toolbar.setTitle("About car");
		setSupportActionBar(toolbar);

		Intent intent = getIntent();
		int id = intent.getIntExtra("idCar", 1);

		DatabaseHelper db = new DatabaseHelper(AboutCarActivity.this);
		Car car = db.getCarById(id);

	}
}