package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;

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

		imageView = findViewById(R.id.imageViewCar);
		textView = findViewById(R.id.textViewTitle);

		Intent intent = getIntent();
		int id = intent.getIntExtra("idCar", 1);

		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		Car car = db.getCarById(id);
		Log.i("idCar", "Model : " + car.getImagePath());
		imageView.setImageResource((int) car.getImagePath());
		textView.setText(car.getModel());

	}
}