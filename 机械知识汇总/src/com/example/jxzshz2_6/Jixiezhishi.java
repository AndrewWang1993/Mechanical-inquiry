package com.example.jxzshz2_6;

import com.example.jixiezhishi.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Jixiezhishi extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jixiezhishi);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jixiezhishi, menu);
		return true;
	}

}
