package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import database.Car;
import database.DatabaseHelper;
import database.MercedesBenz;

public class MenuCarsActivity extends AppCompatActivity {

	RelativeLayout recyclerViewSportCars, recyclerViewSuvsCars, recyclerViewElectricCars;
	String category = "", title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_cars);
		Toolbar toolbar = findViewById(R.id.toolBar);
		setSupportActionBar(toolbar);

		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		Log.d("sizeDB", "sizeDB " + db.getCountCars());
		if (db.getCountCars() == 0) {
			MercedesBenz mb = new MercedesBenz();
			ArrayList<Car> cars = mb.getArrayList();
			for (Car car: cars) {
				db.addCar(car);
			}
		}

		recyclerViewSportCars = findViewById(R.id.relativeLayoutSportCar);
		recyclerViewSuvsCars = findViewById(R.id.relativeLayoutSuvsCars);
		recyclerViewElectricCars = findViewById(R.id.relativeLayoutElectricCars);

		recyclerViewSportCars.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				category = "sport";
				title = "Sports Cars";
				createNewActivity();
			}
		});

		recyclerViewSuvsCars.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				category = "suvs";
				title = "SUVs Cars";
				createNewActivity();
			}
		});

		recyclerViewElectricCars.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MenuCarsActivity.this, "У розробці", Toast.LENGTH_LONG).show();
				category = "electric";
			}
		});

	}

	public void createNewActivity() {
		Intent intent = new Intent(getApplicationContext(), CategoryCarsActivity.class);
		intent.putExtra("category", this.category);
		intent.putExtra("title", title);
		startActivity(intent);
	}

}

