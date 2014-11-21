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

public class Guancai extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guancai);

		final Button btgcjisuan = (Button) findViewById(R.id.btgcjisuan);
		final TextView tvgcmidu = (TextView) findViewById(R.id.tvgcmidu);
		final EditText etgcwaijing = (EditText) findViewById(R.id.etgcwaijing);
		final EditText etgcbihou = (EditText) findViewById(R.id.etgcbihou);
		final EditText etgcchangdu = (EditText) findViewById(R.id.etgcchangdu);
		final EditText etgcdanjia = (EditText) findViewById(R.id.etgcdanjia);
		final TextView zhongliang = (TextView) findViewById(R.id.zhongliang);
		final TextView jiage = (TextView) findViewById(R.id.jiage);

		tvgcmidu.setText("7.85");

		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.cailiao, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spn1 = (Spinner) findViewById(R.id.spgccailiaoleixing);
		spn1.setAdapter(adapter1);

		spn1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (arg2 == 0)
					tvgcmidu.setText("7.85");
				if (arg2 == 1)
					tvgcmidu.setText("7.9");
				if (arg2 == 2)
					tvgcmidu.setText("2.7");
				if (arg2 == 3)
					tvgcmidu.setText("8.5");
				if (arg2 == 4)
					tvgcmidu.setText("8.9");
				if (arg2 == 5)
					tvgcmidu.setText("1.1");

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		btgcjisuan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float mess = Float.parseFloat(tvgcmidu.getText().toString());
				float dim = Float.parseFloat(etgcwaijing.getText().toString());
				float bihou = Float.parseFloat(etgcbihou.getText().toString());
				float len = Float.parseFloat(etgcchangdu.getText().toString());
				float pri = Float.parseFloat(etgcdanjia.getText().toString());

				float wei = (float) (Math.pow(dim / 1000 / 2, 2) * Math.PI
						* len / 1000)
						* mess
						- (float) (Math.pow((dim-bihou) / 1000 / 2, 2) * Math.PI * len / 1000);
				float price = wei * pri;

				zhongliang.setText(String.valueOf(wei) + "ถึ");
				jiage.setText(String.valueOf(price) + "ิช");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.guancai, menu);
		return true;
	}

}
