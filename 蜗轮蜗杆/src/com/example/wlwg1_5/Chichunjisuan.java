package com.example.wlwg1_5;




import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Chichunjisuan extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chichunjisuan);
        final Button button1 = (Button) findViewById(R.id.button1);
		final EditText editText1 = (EditText) findViewById(R.id.editText1);
		final EditText editText2 = (EditText) findViewById(R.id.editText2);
		final EditText editText3 = (EditText) findViewById(R.id.editText3);
		final TextView textView4 = (TextView) findViewById(R.id.textView4);
		
		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float a,b,c,d,e,f,g,temp1,temp2,temp3;
	           temp1=Float.parseFloat(editText1.getText().toString());   //齿数
	           temp2=Float.parseFloat(editText2.getText().toString());   //头数
	           temp3=Float.parseFloat(editText3.getText().toString());   //模数
				
	           a=temp1*temp2;
	           c=(temp1+2)*temp3;
	           d=temp1*temp3;
	           e=c-2*temp3;
	           f=(float) (Math.PI*temp3*temp2);
	           g=(temp2*temp3)/d;
	           b=(d*e)/f;
				
				
				textView4.setText("传动比："+String.valueOf(a)+
						"\n中心距："+String.valueOf(b)+
						"\n涡轮外径："+String.valueOf(c)+
						"\n涡轮节径："+String.valueOf(d)+
						"\n蜗杆节径："+String.valueOf(e)+
						"\n蜗杆导程："+String.valueOf(f)+
						"\n螺旋角："+String.valueOf(g)
						
						
						);
			}
			});
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chichunjisuan, menu);
        return true;
    }
    
}
