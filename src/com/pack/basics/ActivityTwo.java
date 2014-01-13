package com.pack.basics;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


//List activity class
public class ActivityTwo extends ListActivity{
	
	String classNames[] = {"MainActivity", "Sweet", "ActivityThree", "ActivityFour", "SurfaceViewExample"};
	String names[] = {"Main", "Popup", "Image Background Changer", "Animation", "ThreadedAnimation" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names));
	}
	
	protected void onListItemClick(ListView lv, View v, int position, long id){
		super.onListItemClick(lv, v, position, id);
		String openClass = classNames[position];
		try{
			Class selected = Class.forName("com.pack.basics." + openClass);
			Intent selectedIntent = new Intent(this, selected);
			startActivity(selectedIntent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//finish();
	}

}
