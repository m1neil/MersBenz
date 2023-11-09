package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import database.Car;
import database.DatabaseHelper;

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
			ArrayList<Car> cars = getListCars();
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
			}
		});

		recyclerViewElectricCars.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
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

	public ArrayList<Car> getListCars() {
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car(R.drawable.merc_amg_gt, R.raw.merc_amg_gt, "Mercedes-AMG GT", "Опис: Mercedes-AMG GT - це спортивний автомобіль, який вперше був представлений у " +
			"2014 році. Його виробляє німецький автовиробник Mercedes-Benz. Автомобіль доступний " +
			"у двох варіантах кузова: купе та кабріолет.", "2014",
			"Німеччина", "2 двері і 4 місця", "310 км/год",
			"Автоматична ", "Повний", "Бензин", "66 літрів",
			"1 084 834$", "sport")
		);

		return cars;
	}
}