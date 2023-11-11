package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);

		Intent intent = getIntent();
		int pathVideo = intent.getIntExtra("video", 0);

		VideoView videoView = findViewById(R.id.videoView);
		videoView.setVideoPath("android.resource://" + getPackageName() + "/" + pathVideo);

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
	}
}