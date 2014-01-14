//Threads and template for threads in surfaceview activity

package com.pack.basics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class SurfaceViewExample extends Activity implements OnTouchListener{
	
	OurView v;
	Bitmap ball;
	float x, y;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		v = new OurView(this);
		v.setOnTouchListener(this);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball2);
		x = 0;
		y = 0;
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
			while (IsItOK == true){
				// draw canvas
				if(!holder.getSurface().isValid()){
					continue;
				}
				Canvas c = holder.lockCanvas();
				c.drawARGB(255, 150, 150, 10);
				c.drawBitmap(ball, x -(ball.getWidth()/2), y - (ball.getHeight()/2), null);
				holder.unlockCanvasAndPost(c);
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

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(event.getAction()){
		
		case MotionEvent.ACTION_DOWN:
			x = event.getX();
			y = event.getY();
			break;
			
		case MotionEvent.ACTION_UP:
			x = event.getX();
			y = event.getY();
			break;
			
		case MotionEvent.ACTION_MOVE:
			x = event.getX();
			y = event.getY();
			break;
		
		}
		return true;
	}

}
