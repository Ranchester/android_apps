package com.pack.basics;

import android.app.Activity;
import android.os.Bundle;

public class ActivityFour extends Activity {
	
	DrawingTheBall v;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// Draw image from DrawingTheBall class
		v = new DrawingTheBall(this);
		setContentView(v);
		
	}

}
