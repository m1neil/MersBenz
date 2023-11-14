package com.example.mersbens;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

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

//		ActionBar actionBar = this.getSupportActionBar();
//		if (actionBar != null) {
//			actionBar.setDisplayHomeAsUpEnabled(true);
//		}

		DatabaseHelper db = new DatabaseHelper(FavouriteCarsActivity.this);
		SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
		User user = db.getUserByByEmailFullInfo(sharedPreferences.getInt("idUser", 0));

		if (user.getLikeCars().length() > 0) {


			List<String> likeCarList = new ArrayList<>(Arrays.asList(user.getLikeCars().split(",")));
			ArrayList<Car> carsList = new ArrayList<>();
			for (int i = 0; i < likeCarList.size(); i++) {
				int idCar = Integer.parseInt(likeCarList.get(i));
				Car car = db.getCarById(idCar);
				if (car.getId() != 0) {
					carsList.add(car);
				}
			}

			recyclerView = findViewById(R.id.recyclerViewCars);
			recyclerView.setHasFixedSize(true);
			adapter = new CarCardAdapter(carsList, FavouriteCarsActivity.this);
			layoutManager = new LinearLayoutManager(FavouriteCarsActivity.this);
			recyclerView.setAdapter(adapter);
			recyclerView.setLayoutManager(layoutManager);
		}
	}
}