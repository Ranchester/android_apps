package com.pack.basics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceViewExample extends Activity{
	
	OurView v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		v = new OurView(this);
		
		setContentView(v);
	}
	
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		v.pause();
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		v.resume();
	}



	public class OurView extends SurfaceView implements Runnable {
		
		Thread t = null;
		SurfaceHolder holder;
		boolean IsItOK = false;
		

		public OurView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			holder = getHolder();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (IsItOK == true){
				// draw canvas
			}
			
		}
		
		public void pause(){
			IsItOK = false;
			while(true){
				try{
					t.join();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				break;
			}
			t = null;
		}
		
		public void resume(){
			IsItOK = true;
			t = new Thread(this);
			t.start();
		}
		
	
	}

}
