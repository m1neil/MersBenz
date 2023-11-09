package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;

import android.app.StatusBarManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

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

		new CountDownTimer(0, 0) {

			@Override
			public void onTick(long millisUntilFinished) {

			}

			@Override
			public void onFinish() {
				Intent intent = new Intent(getApplicationContext(), MenuCarsActivity.class);
				startActivity(intent);
			}
		}.start();
	}
}