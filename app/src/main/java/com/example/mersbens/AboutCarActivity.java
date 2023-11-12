package com.example.mersbens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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
		textViewDriveUnit,
		textViewEngineName,
		textViewEngineDesc,
		textViewSuspensionDesc,
		textViewTransmissionDesc,
		textViewBreakSystemDesc,
		textViewWheelsTiresDesc,
		textViewElectricalEquipmentDesc,
		textViewFuelType;

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
		textViewEngineName = findViewById(R.id.textViewEngine);
		textViewEngineDesc = findViewById(R.id.textViewEngineDesc);
		textViewSuspensionDesc = findViewById(R.id.textViewSuspensionDesc);
		textViewTransmissionDesc = findViewById(R.id.textViewTransmissionDesc);
		textViewBreakSystemDesc = findViewById(R.id.textViewBreakSystemDesc);
		textViewWheelsTiresDesc = findViewById(R.id.textViewWheelsTiresDesc);
		textViewElectricalEquipmentDesc = findViewById(R.id.textViewElectricalEquipmentDesc);
		textViewFuelType = findViewById(R.id.textViewFuelType);

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
		textViewEngineName.setText(car.getEngine());
		textViewEngineDesc.setText(car.getEngineDescr());
		textViewSuspensionDesc.setText(car.getSuspensionDescr());
		textViewTransmissionDesc.setText(car.getTransmissionDescr());
		textViewBreakSystemDesc.setText(car.getBrakeSystemDescr());
		textViewWheelsTiresDesc.setText(car.getWheelsTiresDescr());
		textViewElectricalEquipmentDesc.setText(car.getElectricalEquipment());
		textViewFuelType.setText(car.getFuelType());

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

		ActionBar actionBar = this.getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		int id = item.getItemId();
		if (id == android.R.id.home) {
			NavUtils.navigateUpFromSameTask(this);
		}
		return super.onOptionsItemSelected(item);
	}
}