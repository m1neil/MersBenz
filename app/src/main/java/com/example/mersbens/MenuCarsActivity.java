package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import database.Car;
import database.DatabaseHelper;
import database.MercedesBenz;

public class MenuCarsActivity extends AppCompatActivity {

	RelativeLayout recyclerViewSportCars, recyclerViewSuvsCars, recyclerViewElectricCars,
		recyclerViewFavouriteCats;
	String category = "", title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_cars);
		Toolbar toolbar = findViewById(R.id.toolBar);
		setSupportActionBar(toolbar);

		DatabaseHelper db = new DatabaseHelper(getApplicationContext());
		Log.d("sizeDB", "sizeDB " + db.getCountCars());

		MercedesBenz mb = new MercedesBenz();
		ArrayList<Car> cars = mb.getArrayList();
		for (Car car : cars) {
			int id = db.getCarByName(car.getModel());
			if (id == 0) {
				db.addCar(car);
			}
		}

		recyclerViewSportCars = findViewById(R.id.relativeLayoutSportCar);
		recyclerViewSuvsCars = findViewById(R.id.relativeLayoutSuvsCars);
		recyclerViewElectricCars = findViewById(R.id.relativeLayoutElectricCars);
		recyclerViewFavouriteCats = findViewById(R.id.relativeLayoutFavoriteCars);

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
				category = "electric";
				title = "ELECTRIC Cars";
				createNewActivity();
			}
		});

		recyclerViewFavouriteCats.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), FavouriteCarsActivity.class);
				startActivity(intent);
			}
		});

	}

	public void createNewActivity() {
		Intent intent = new Intent(getApplicationContext(), CategoryCarsActivity.class);
		intent.putExtra("category", this.category);
		intent.putExtra("title", title);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);

		MenuItem item = menu.findItem(R.id.action_favourite);
		MenuItem item2 = menu.findItem(R.id.action_home);
		item.setVisible(false);
		item2.setVisible(false);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_exit) {
			SharedPreferences sharedPreferences = this.getSharedPreferences("user", Context.MODE_PRIVATE);
			SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
			sharedEditor.putInt("idUser", 0);
			sharedEditor.apply();
			restartApplication();

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void restartApplication() {
		PackageManager packageManager = getPackageManager();
		String packageName = getPackageName();
		Intent intent = packageManager.getLaunchIntentForPackage(packageName);

		if (intent != null) {
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			finish();
		}
	}

}

