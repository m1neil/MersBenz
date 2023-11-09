package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class MenuCarsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_cars);

		Toolbar toolbar = findViewById(R.id.toolBar);
		setSupportActionBar(toolbar);
	}
}