package com.pack.basics;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityThree extends Activity implements OnClickListener {
	
	ImageView display;
	int tophone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// removes apptitle from the view
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.example3);
		
		tophone = R.drawable.kuva1;
		
		//setup images
		display = (ImageView) findViewById(R.id.IView);
		ImageView image1 = (ImageView) findViewById(R.id.IVlist);
		ImageView image2 = (ImageView) findViewById(R.id.IVlist2);
		ImageView image3 = (ImageView) findViewById(R.id.IVlist3);
		ImageView image4 = (ImageView) findViewById(R.id.IVlist4);
		ImageView image5 = (ImageView) findViewById(R.id.IVlist5);
		Button setwp = (Button) findViewById(R.id.BchangeBg);
		
		//setting images to buttons
		image1.setOnClickListener(this);
		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		image5.setOnClickListener(this);
		setwp.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// click listeners for images and a button
				
		switch (v.getId()){
		case R.id.IVlist:
			display.setImageResource(R.drawable.kuva1);
			tophone = R.drawable.kuva1;
			break;
		case R.id.IVlist2:
			display.setImageResource(R.drawable.kuva2);
			tophone = R.drawable.kuva2;
			break;
		case R.id.IVlist3:
			display.setImageResource(R.drawable.kuva3);
			tophone = R.drawable.kuva3;
			break;
		case R.id.IVlist4:
			display.setImageResource(R.drawable.kuva4);
			tophone = R.drawable.kuva4;
			break;
		case R.id.IVlist5:
			display.setImageResource(R.drawable.background1);
			tophone = R.drawable.background1;
			break;
		case R.id.BchangeBg:
			InputStream stream = getResources().openRawResource(tophone);
			Bitmap map = BitmapFactory.decodeStream(stream);
			try{
				getApplicationContext().setWallpaper(map);
			}catch(IOException e){
				e.printStackTrace();
			}
			//Note for user
			Toast toast = Toast.makeText(ActivityThree.this, "Background picture changed!", Toast.LENGTH_LONG);
			toast.show();
			break;
		}
	}
	
	

}
