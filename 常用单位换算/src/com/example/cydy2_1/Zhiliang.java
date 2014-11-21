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

public class Zhiliang extends Activity {
	int flag=1;
	double input;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhiliang);
		
		
		
		final Button button1 = (Button) findViewById(R.id.button1);
		final EditText changdu = (EditText) findViewById(R.id.editText1);
		final TextView textView3 = (TextView) findViewById(R.id.textView3);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.zhiliang, android.R.layout.simple_spinner_item);
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
				double a,b,c,d,e,f,temp=0;
	             input = Double.valueOf(changdu.getText().toString());
	             
	             if(flag==1){
	            	 temp=input*10;      //选取"公担"为基准        	
	             }
	             else if(flag==2){
	            	temp=input;
	             }
	             else if(flag==3){
	            	 temp=input/100;
	             }
	             else if(flag==4){
	            	 temp=input/10000;
	             }
	             else if(flag==4){
	            	 temp=input/100000;
	             }
	             else if(flag==5){
	            	 temp=input/10000000;
	             }
	             else if(flag==6){
	            	 temp=input/Math.pow(10, 10);
	             }
	             
	             
	             
	             b=temp;
	             a=b/10;
            	 c=b*100;
            	 d=c*1000;
            	 e=d*1000;
            	 f=e*1000;
            	 ;
	             
	             
				textView3.setText(String.valueOf(a)+" 吨\n"
						+String.valueOf(b)+" 公担\n"
						+String.valueOf(c)+" 千克\n"
						+String.valueOf(d)+" 克\n"
						+String.valueOf(e)+" 毫克\n"
						+String.valueOf(f)+" 微克\n"
						
						
						);
			}
			});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zhiliang, menu);
		return true;
	}

}
