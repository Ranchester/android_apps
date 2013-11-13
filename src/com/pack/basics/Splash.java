package com.pack.basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Thread startTimer = new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					sleep(1000);
					Intent i = new Intent("com.pack.basics.ACTIVITYTWO");
					startActivity(i);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
					
				}
				
				finally {
					finish();
				}
			}
		};
		startTimer.start();
	}

}
