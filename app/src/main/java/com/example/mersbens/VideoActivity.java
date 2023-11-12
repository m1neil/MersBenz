package com.example.mersbens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);

		Intent intent = getIntent();
		int pathVideo = intent.getIntExtra("video", 0);
		String model = intent.getStringExtra("model");

		Toolbar toolbar = findViewById(R.id.toolBar);
		toolbar.setTitle(model);
		setSupportActionBar(toolbar);

		ActionBar actionBar = this.getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		VideoView videoView = findViewById(R.id.videoView);
		videoView.setVideoPath("android.resource://" + getPackageName() + "/" + pathVideo);
		videoView.seekTo(4);

		MediaController mediaController = new MediaController(this);
		mediaController.setAnchorView(videoView);

		videoView.setMediaController(mediaController);

		ImageButton imageButton = findViewById(R.id.imageButtonPlay);
		imageButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				videoView.start();
				imageButton.setVisibility(View.GONE);
			}
		});

		TextView textViewTitle = findViewById(R.id.textViewModelTitle);
		textViewTitle.setText(model);
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		int id = item.getItemId();
		if (id == android.R.id.home) {
			NavUtils.navigateUpFromSameTask(this);
		} else if (id == R.id.action_home) {
			Intent intent = new Intent(VideoActivity.this, MenuCarsActivity.class);
			startActivity(intent);
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// bakc home
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		return true;
	}
	// ====================================================

}