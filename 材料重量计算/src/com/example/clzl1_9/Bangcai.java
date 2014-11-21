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
import android.widget.AdapterView.OnItemSelectedListener;

public class Bangcai extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bangcai);
		
		final Button btybjisuan = (Button) findViewById(R.id.btybjisuan);
		final TextView tvybmidu = (TextView) findViewById(R.id.tvybmidu);
		final EditText etybzhijing = (EditText) findViewById(R.id.etybzhijing);
		final EditText etybchangdu = (EditText) findViewById(R.id.etybchangdu);
		final EditText etybdanjia = (EditText) findViewById(R.id.etybdanjia);
		final TextView zhongliang1 = (TextView) findViewById(R.id.zhongliang1);
		final TextView jiage1 = (TextView) findViewById(R.id.jiage1);
		
		tvybmidu.setText("7.85");
		
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.cailiao, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spn1 = (Spinner) findViewById(R.id.spybcailiaoleixing);
		spn1.setAdapter(adapter1);
		
		
		spn1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if(arg2==0)
					tvybmidu.setText("7.85");
				if(arg2==1)
					tvybmidu.setText("7.9");
				if(arg2==2)
					tvybmidu.setText("2.7");
				if(arg2==3)
					tvybmidu.setText("8.5");
				if(arg2==4)
					tvybmidu.setText("8.9");
				if(arg2==5)
					tvybmidu.setText("1.1");		
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
		
		
		
		btybjisuan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
              float mess=Float.parseFloat(tvybmidu.getText().toString());
              float dim= Float.parseFloat(etybzhijing.getText().toString());
              float len=Float.parseFloat(etybchangdu.getText().toString());
              float pri=Float.parseFloat(etybdanjia.getText().toString());
              
              float wei=(float)(Math.pow(dim/1000/2, 2) *Math.PI*len/1000)*mess; 
              float price=wei*pri;
              
              zhongliang1.setText(String.valueOf(wei)+"ถึ");
              jiage1.setText(String.valueOf(price)+"ิช");
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bangcai, menu);
		return true;
	}

}
