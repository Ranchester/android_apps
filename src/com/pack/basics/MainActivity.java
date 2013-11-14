package com.pack.basics;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnCheckedChangeListener{
	
	TextView textOut;
	EditText textIn;
	RadioGroup gravityG, styleG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example1);
        textOut = (TextView) findViewById(R.id.textView3);
        textIn = (EditText) findViewById(R.id.edittext1);
        gravityG = (RadioGroup) findViewById(R.id.rgGravity);
        gravityG.setOnCheckedChangeListener(this);
        styleG = (RadioGroup) findViewById(R.id.rgStyle);
        styleG.setOnCheckedChangeListener(this);
        
        Button gen = (Button) findViewById(R.id.bGenerate);
        
        gen.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textOut.setText(textIn.getText());
				
			}
		});
        
        Button activity = (Button) findViewById(R.id.button2);
        
        
        activity.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.pack.basics.ACTIVITYTWO"));
				
			}
		});
        		
    }

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// Radiogroup activities
		switch(checkedId){
			case R.id.rbLeft:
				textOut.setGravity(Gravity.LEFT);
				break;
			case R.id.rbCenter:
				textOut.setGravity(Gravity.CENTER);
				break;
			case R.id.rbRight:
				textOut.setGravity(Gravity.RIGHT);
				break;
			case R.id.rbNormal:
				textOut.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL), Typeface.NORMAL);
				break;
			case R.id.rbBold:
				textOut.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD), Typeface.BOLD);
				break;
			case R.id.rbItalic:
				textOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC), Typeface.ITALIC);
				break;
			
		}
		
	}

	/*
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Make menus
		super.onCreateOptionsMenu(menu);
		MenuInflater awesome = getMenuInflater();
		awesome.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Menu_toast_popups
		switch (item.getItemId()){
		case R.id.menuSweet:
			startActivity(new Intent("com.pack.basics.SWEET"));
			return true;
		case R.id.menuToast:
			Toast toast = Toast.makeText(MainActivity.this, "This is a toast", Toast.LENGTH_LONG);
			toast.show();
			return true;
		}
		return false;
	}
	
	

	
	
  }
