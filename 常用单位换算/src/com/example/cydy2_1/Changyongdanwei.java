package com.example.cydy2_1;



import com.example.cydy2_1.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Changyongdanwei extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changyongdanwei);
		
		final Button button1 = (Button) findViewById(R.id.button1);

		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(Changyongdanwei.this,
						Changdu.class);
				startActivity(intent);

			}
			});
		
		final Button button2 = (Button) findViewById(R.id.button2);
		
		
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(Changyongdanwei.this,
						Mianji.class);
				startActivity(intent);
				
			}
		});
		
		final Button button3= (Button) findViewById(R.id.button3);
		
		
		button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(Changyongdanwei.this,
						Midu.class);
				startActivity(intent);
				
			}
		});
		final Button button4= (Button) findViewById(R.id.button4);
		
		
		button4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(Changyongdanwei.this,
						Tiji.class);
				startActivity(intent);
				
			}
		});
		final Button button5= (Button) findViewById(R.id.button5);
		
		
		button5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(Changyongdanwei.this,
						Shijian.class);
				startActivity(intent);
				
			}
		});
		final Button button6= (Button) findViewById(R.id.button6);
		
		
		button6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(Changyongdanwei.this,
						Zhiliang.class);
				startActivity(intent);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.changyongdanwei, menu);
		return true;
	}

}
