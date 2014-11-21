package com.example.clsj1_4;

import com.example.chi.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Zhichilun extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhichilun);
		

		final Button button21 = (Button) findViewById(R.id.button21);
		final EditText editText21 = (EditText) findViewById(R.id.editText21);
		final EditText editText22 = (EditText) findViewById(R.id.editText22);
		final TextView textView210 = (TextView) findViewById(R.id.textView210);

		button21.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float ms = Float.parseFloat(editText21.getText().toString());
				float cs = Float.parseFloat(editText22.getText().toString());

				float a = ms * cs, b = ms, c = (float) (1.25 * ms), d = (float) (2.25 * ms), e = a
						+ 2 * b, f = a - 2 * c, g = (float) (ms * cs * Math
						.sin(90 / cs / 180 * Math.PI)), h = (float) (ms + ms
						* cs / 2 * (1 - Math.cos(90 / cs / 180 * Math.PI)));
				
				textView210.setText("分度圆直径：" + String.valueOf(a)
						+ "\n齿顶高："+String.valueOf(b)
						+ "\n齿根高："+String.valueOf(c)
						+"\n全齿高"+String.valueOf(d)+
						"\n齿顶圆直径："+String.valueOf(e) 
						+ "\n齿根圆直径："+String.valueOf(f)
						+"\n分度圆弦齿厚："+String.valueOf(g)
						+ "\n分度圆弦齿高："+String.valueOf(h)
						);


			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zhichilun, menu);
		return true;
	}

}
