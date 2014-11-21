package com.example.clzl1_9;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Caogang extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.caogang);
		
		final Button jisuan = (Button) findViewById(R.id.btcgjisuan);
		final TextView zhongliang = (TextView) findViewById(R.id.tvcgzhongliangjieguo);
		final TextView jiage = (TextView) findViewById(R.id.tvcgjiagejieguo);
		
		final TextView t3 = (TextView) findViewById(R.id.tvcgdanzhong);
		final EditText e1=(EditText) findViewById(R.id.etcgchangdu);
		final EditText e2=(EditText) findViewById(R.id.etcgdanjia);
		
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.caogang, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		
		Spinner spn = (Spinner) findViewById(R.id.spcgxinghao);
		spn.setAdapter(adapter);
		
		spn.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if(arg2==0)
					t3.setText("5.438");
				if(arg2==1)
                   t3.setText("6.634");
				if(arg2==2)
					t3.setText("8.046");
				if(arg2==3)
					t3.setText("10.007");
				if(arg2==4)
					t3.setText("12.059");
				if(arg2==5)
					t3.setText("14.535");
				if(arg2==6)
					t3.setText("16.733");
				if(arg2==7)
					t3.setText("17.24");
				if(arg2==8)
					t3.setText("19.752");
				
				if(t3.getText().toString().equalsIgnoreCase("6.634"))
					Toast.makeText(Caogang.this,
						"您现在选择的是：6.3号槽钢。", Toast.LENGTH_LONG)
						.show();
				if(t3.getText().toString().equalsIgnoreCase("8.046"))
					Toast.makeText(Caogang.this,
							"您现在选择的是：8号槽钢。", Toast.LENGTH_LONG)
							.show();
				if(t3.getText().toString().equalsIgnoreCase("10.007"))
					Toast.makeText(Caogang.this,
							"您现在选择的是：10号槽钢。", Toast.LENGTH_LONG)
							.show();
				if(t3.getText().toString().equalsIgnoreCase("12.059"))
					Toast.makeText(Caogang.this,
							"您现在选择的是：12号槽钢。", Toast.LENGTH_LONG)
							.show();
				if(t3.getText().toString().equalsIgnoreCase("14.535"))
					Toast.makeText(Caogang.this,
							"您现在选择的是：14a号槽钢。", Toast.LENGTH_LONG)
							.show();
				if(t3.getText().toString().equalsIgnoreCase("16.733"))
					Toast.makeText(Caogang.this,
							"您现在选择的是：14b号槽钢。", Toast.LENGTH_LONG)
							.show();
				if(t3.getText().toString().equalsIgnoreCase("17.24"))
					Toast.makeText(Caogang.this,
							"您现在选择的是：14b号槽钢。", Toast.LENGTH_LONG)
							.show();
				if(t3.getText().toString().equalsIgnoreCase("19.752"))
					Toast.makeText(Caogang.this,
							"您现在选择的是：16b号槽钢。", Toast.LENGTH_LONG)
							.show();
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		
		
		jisuan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float a,b,c;
				a=Float.parseFloat(t3.getText().toString());
				b=Float.parseFloat(e1.getText().toString());
				c=Float.parseFloat(e2.getText().toString());
				zhongliang.setText(String.valueOf(b/1000*a)+" 千克");
				jiage.setText(String.valueOf(b/1000*a/1000*c)+" 元");
				
			}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.caogang, menu);
		return true;
	}

}
