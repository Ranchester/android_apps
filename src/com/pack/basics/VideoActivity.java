package com.pack.basics;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {
	
	VideoView myVideo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video);
		myVideo = (VideoView)findViewById(R.id.video);
		String videopath = "android.resource://" + getPackageName() + "/" + R.raw.bean;
		myVideo.setVideoURI(Uri.parse(videopath));
		myVideo.start();
		
		MediaController controls = new MediaController(this);
		controls.setMediaPlayer(myVideo);
		myVideo.setMediaController(controls);
	}
	
}
