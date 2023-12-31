package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import database.Car;
import database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
	TextView textViewLogoTitle;
	ImageView imageViewLogo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textViewLogoTitle = findViewById(R.id.textViewLogoTitle);
		imageViewLogo = findViewById(R.id.imageViewLogo);
		textViewLogoTitle.animate().scaleX(1).scaleY(1).setDuration(900);
		imageViewLogo.animate().scaleX(1).scaleY(1).setDuration(900);

		new CountDownTimer(1000, 1000) {

			@Override
			public void onTick(long millisUntilFinished) {

			}

			@Override
			public void onFinish() {
				SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
				Intent intent;
				if (sharedPreferences.getInt("idUser", 0) != 0) {
					intent = new Intent(MainActivity.this, MenuCarsActivity.class);
				} else {
					intent = new Intent(MainActivity.this, LoginActivity.class);
				}

				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				finish();
			}
		}.start();
	}

}