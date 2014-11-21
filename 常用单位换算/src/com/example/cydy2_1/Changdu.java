package com.example.cydy2_1;


import com.example.cydy2_1.R;

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
import android.widget.AdapterView.OnItemSelectedListener;

public class Changdu extends Activity {
	int flag=1;
	float input;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changdu);
		
		
		final Button button1 = (Button) findViewById(R.id.button1);
		final EditText changdu = (EditText) findViewById(R.id.editText1);
		final TextView textView3 = (TextView) findViewById(R.id.textView3);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.changdu, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setAdapter(adapter);
		
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
				flag=arg2+1;
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		
		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float a,b,c,d,e,f,g,temp=0;
	             input = Float.parseFloat(changdu.getText().toString());
	             
	             if(flag==1){
	            	 temp=input*1000;      //选取"米"为基准        	
	             }
	             else if(flag==2){
	            	temp=input;
	             }
	             else if(flag==3){
	            	 temp=input/10;
	             }
	             else if(flag==4){
	            	 temp=input/100;
	             }
	             else if(flag==4){
	            	 temp=input/1000;
	             }
	             else if(flag==5){
	            	 temp=input/1000000;
	             }
	             else if(flag==6){
	            	 temp=input/1000000000;
	             }
	             
	             
	             
	             b=temp;
	             a=b/1000;
            	 c=b*10;
            	 d=c*10;
            	 e=d*10;
            	 f=e*1000;
            	 g=f*1000;
	             
	             
				textView3.setText(String.valueOf(a)+" 千米\n"
						+String.valueOf(b)+" 米\n"
						+String.valueOf(c)+" 分米\n"
						+String.valueOf(d)+" 厘米\n"
						+String.valueOf(e)+" 毫米\n"
						+String.valueOf(f)+" 微米\n"
						+String.valueOf(g)+" 纳米\n"
						
						
						);
			}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.changdu, menu);
		return true;
	}

}
