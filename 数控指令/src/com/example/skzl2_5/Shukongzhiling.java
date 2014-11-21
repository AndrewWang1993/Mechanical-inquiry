package com.example.skzl2_5;

import com.example.shukongzhiling.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class Shukongzhiling extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shukongzhiling);

		final TextView zhiling = (TextView) findViewById(R.id.backtv);
		zhiling.setText(getString(R.string.jc0));
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.jichuang, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spn1 = (Spinner) findViewById(R.id.cncsp);
		spn1.setAdapter(adapter1);
		spn1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				if (arg2 == 0) {
					zhiling.setText(getString(R.string.jc0));
				}
				if (arg2 == 1) {
					zhiling.setText(getString(R.string.jc1));
				}
				if (arg2 == 2) {
					zhiling.setText(getString(R.string.jc2));
				}
				if (arg2 == 3) {
					zhiling.setText(getString(R.string.jc3));
				}
				if (arg2 == 4) {
					zhiling.setText(getString(R.string.jc4));
				}
				if (arg2 == 5) {
					zhiling.setText(getString(R.string.jc5));
				}
				if (arg2 == 6) {
					zhiling.setText(getString(R.string.jc6));
				}
				if (arg2 == 7) {
					zhiling.setText(getString(R.string.jc7));
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shukongzhiling, menu);
		return true;
	}

}
