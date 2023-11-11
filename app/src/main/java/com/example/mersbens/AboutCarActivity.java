package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import database.Car;
import database.DatabaseHelper;

public class AboutCarActivity extends AppCompatActivity {

	ImageView imageViewCar;
	TextView textViewModelCar,
		textViewPrice,
		textViewDescription,
		textViewYear,
		textViewCountry,
		textViewMaxSpeed,
		textViewTankCapacity,
		textViewTransmission,
		textViewDoorAndPlaces,
		textViewDriveUnit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_car);
		Toolbar toolbar = findViewById(R.id.toolBar);
		toolbar.setTitle("About car");
		setSupportActionBar(toolbar);

		imageViewCar = findViewById(R.id.imageViewCar);
		textViewModelCar = findViewById(R.id.textViewModelCar);
		textViewPrice = findViewById(R.id.textViewPrice);
		textViewDescription = findViewById(R.id.textViewDescription);
		textViewYear = findViewById(R.id.textViewYear);
		textViewCountry = findViewById(R.id.textViewCountry);
		textViewMaxSpeed = findViewById(R.id.textViewMaxSpeed);
		textViewTankCapacity = findViewById(R.id.textViewTankCapacity);
		textViewTransmission = findViewById(R.id.textViewTransmission);
		textViewDoorAndPlaces = findViewById(R.id.textViewDoor);
		textViewDriveUnit = findViewById(R.id.textViewDriveUnit);

		Intent intent = getIntent();
		int id = intent.getIntExtra("idCar", 1);

		DatabaseHelper db = new DatabaseHelper(AboutCarActivity.this);
		Car car = db.getCarById(id);
		imageViewCar.setImageResource(car.getImagePathSecond());
		textViewModelCar.setText(car.getModel());
		textViewPrice.append(car.getMiddlePrice());
		textViewDescription.append(car.getDescription());
		textViewYear.setText(car.getYearProduced());
		textViewCountry.setText(car.getCountryProduced());
		textViewMaxSpeed.setText(car.getMaxSpeed());
		textViewTankCapacity.setText(car.getFuelTankCapacity());
		textViewTransmission.setText(car.getTypeTransmission());
		textViewDoorAndPlaces.setText(car.getCountDoorsAndPlaces());
		textViewDriveUnit.setText(car.getDriveUnit());

		imageViewCar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intentVideo = new Intent(AboutCarActivity.this, VideoActivity.class);
				intentVideo.putExtra("video", car.getVideoPath());
				intentVideo.putExtra("model", car.getModel());
				startActivity(intentVideo);
				Log.d("click", "we clicked");
			}
		});
	}
}