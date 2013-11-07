package com.pack.basics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class DrawingTheBall extends View{
	
	// bitmaps for balls
	Bitmap ball, ball2;
	//cordinates for balls
	int x, y, x1, y1;

	public DrawingTheBall(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball2);
		ball2 = BitmapFactory.decodeResource(getResources(), R.drawable.ball2);
		x = 0;
		y = 0;
		x1 = 100;
		y1 = 100;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		// Setting up reectangle
		Rect ourRect = new Rect();
		ourRect.set(0, 0, canvas.getWidth(), canvas.getHeight()/2);
		
		//Paint rectangle
		Paint blue = new Paint();
		blue.setColor(Color.BLUE);
		blue.setStyle(Paint.Style.FILL);
		
		canvas.drawRect(ourRect, blue);
		
		// animation conditions for balls
		if (x < canvas.getWidth()){
		x += 10;
		x1 += 10;
		}else{
			x = 0;
			x1 = 100;
		}
		if (y < canvas.getHeight()){
		y += 10;
		y1 += 10;
		}else{
			y = 0;
			y1 = 100;
		}
		
		//animate balls
		Paint ballanim = new Paint();
		canvas.drawBitmap(ball, x, y, ballanim);
		Paint ballanim2 = new Paint();
		canvas.drawBitmap(ball2, x1, y1, ballanim2);
		//invalidate class so it can start again
		invalidate();
	}
	
	

}
