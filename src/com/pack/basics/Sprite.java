//Class for the ninja sprite SurfaceViewExample.OurView uses this
package com.pack.basics;

import com.pack.basics.SurfaceViewExample.OurView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {
	int x, y;
	int xSpeed, ySpeed;
	int height, width;
	int currentFrame = 0;
	int direction = 3;
	Bitmap n;
	OurView ov;

	public Sprite(OurView ourView, Bitmap ninja) {
		// TODO Auto-generated constructor stub
		n = ninja;
		ov = ourView;
		x = y = 0;
		xSpeed = 5;
		ySpeed = 0;
		height = n.getHeight() / 4;
		width = n.getWidth() / 6;
	}
	
	private void update() {
		// TODO Auto-generated method stub
		
		//sprite rows and directions
		//row 0 down
		//row 1 left
		//row 2 up
		//row 3 right
		
		//facing down
		if(x > ov.getWidth() - width - xSpeed){
			xSpeed = 0;
			ySpeed = 5;
			direction = 0;
		}
		
		//facing left
		if(y > ov.getHeight() - height - ySpeed){
			xSpeed = -5;
			ySpeed = 0;
			direction = 1;
		}
		
		//facing up
		if(x + xSpeed < 0){
			x = 0;
			xSpeed = 0;
			ySpeed = -5;
			direction = 2;
		}
		
		//facing right
		if(y + ySpeed < 0){
			y = 0;
			xSpeed = 5;
			ySpeed = 0;
			direction = 3;
		}
		
		//slow down speed
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		currentFrame = ++currentFrame % 6;
		x += xSpeed;
		y += ySpeed;
		
	}

	public void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		int srcX = currentFrame * width; //sprites for walking
		int srcY = direction * height; //sprite facing
		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		Rect dst = new Rect(x, y, x+width, y+height);
		canvas.drawBitmap(n, src, dst, null);
		update();
		
	}
}
