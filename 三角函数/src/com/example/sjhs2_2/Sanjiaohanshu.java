package com.example.sjhs2_2;

import com.example.sanjiaohanshu.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sanjiaohanshu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sanjiaohanshu);
		final Button btn = (Button) findViewById(R.id.tgtjisuanbt);
		final EditText enter = (EditText) findViewById(R.id.tgtet);
		final TextView result = (TextView) findViewById(R.id.tgtrestv);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String str = new String();
				str = enter.getText().toString();
				float d = (float) (Float.parseFloat(str)/180*Math.PI);
				result.setText("Sin" + str + "бу = " + String.valueOf(Math.sin(d))
						+ "\nCos" + str + "бу = " + String.valueOf(Math.cos(d))
						+ "\nTan" + str + "бу = " + String.valueOf(Math.tan(d))
						+ "\nArcsin" + str + " = " + String.valueOf(Math.asin(d))
						+ "\nArccos" + str + " = " + String.valueOf(Math.acos(d))
						+ "\nArctan" + str + " = " + String.valueOf(Math.atan(d))

						);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sanjiaohanshu, menu);
		return true;
	}

}
