package com.example.mersbens;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import User.User;
import database.Car;
import database.CarCardAdapter;
import database.DatabaseHelper;

public class FavouriteCarsActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	RecyclerView.Adapter adapter;
	RecyclerView.LayoutManager layoutManager;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favourite_cars);

		Toolbar toolbar = findViewById(R.id.toolBar);
		toolbar.setTitle("Favourite cars");
		setSupportActionBar(toolbar);

		ActionBar actionBar = this.getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		DatabaseHelper db = new DatabaseHelper(FavouriteCarsActivity.this);
		SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
		User user = db.getUserByByEmailFullInfo(sharedPreferences.getInt("idUser", 0));


		ArrayList<Car> carsList = new ArrayList<>();
		if (user.getLikeCars().length() > 0) {
			List<String> likeCarList = new ArrayList<>(Arrays.asList(user.getLikeCars().split(",")));
			for (int i = 0; i < likeCarList.size(); i++) {
				int idCar = Integer.parseInt(likeCarList.get(i));
				Car car = db.getCarById(idCar);
				if (car.getId() != 0) {
					carsList.add(car);
				}
			}
		}

		recyclerView = findViewById(R.id.recyclerViewCars);
		recyclerView.setHasFixedSize(true);
		adapter = new CarCardAdapter(carsList, FavouriteCarsActivity.this);
		layoutManager = new LinearLayoutManager(FavouriteCarsActivity.this);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(layoutManager);
	}


	@Override
	protected void onResume() {
		super.onResume();
		Log.d("onResume", "onResume");

		DatabaseHelper db = new DatabaseHelper(FavouriteCarsActivity.this);
		SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
		User user = db.getUserByByEmailFullInfo(sharedPreferences.getInt("idUser", 0));

		List<String> likeCarList = new ArrayList<>();
		if (user.getLikeCars().length() > 0) {
			likeCarList = new ArrayList<>(Arrays.asList(user.getLikeCars().split(",")));
		}
		ArrayList<Car> carsList = new ArrayList<>();

		for (int i = 0; i < likeCarList.size(); i++) {
			int idCar = Integer.parseInt(likeCarList.get(i));
			Car car = db.getCarById(idCar);
			if (car.getId() != 0) {
				carsList.add(car);
			}
		}

		if (adapter != null) {
			((CarCardAdapter) adapter).updateData(carsList);
			adapter.notifyDataSetChanged();
		}
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
}

