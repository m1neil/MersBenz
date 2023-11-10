package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import database.Car;
import database.CarCardAdapter;
import database.DatabaseHelper;

public class CategoryCarsActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	RecyclerView.Adapter adapter;
	RecyclerView.LayoutManager layoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category_cars);
		Intent intent = getIntent();
		Toolbar toolbar = findViewById(R.id.toolBar);
		toolbar.setTitle(intent.getStringExtra("title"));
		setSupportActionBar(toolbar);

		DatabaseHelper db = new DatabaseHelper(CategoryCarsActivity.this);
		List<Car> list = db.getCarByCategory(intent.getStringExtra("category"));

		recyclerView = findViewById(R.id.recyclerViewCars);
		recyclerView.setHasFixedSize(true);
		adapter = new CarCardAdapter(list, CategoryCarsActivity.this);
		layoutManager = new LinearLayoutManager(CategoryCarsActivity.this);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(layoutManager);
	}
}