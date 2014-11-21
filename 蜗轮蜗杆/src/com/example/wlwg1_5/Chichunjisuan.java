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
	           temp1=Float.parseFloat(editText1.getText().toString());   //����
	           temp2=Float.parseFloat(editText2.getText().toString());   //ͷ��
	           temp3=Float.parseFloat(editText3.getText().toString());   //ģ��
				
	           a=temp1*temp2;
	           c=(temp1+2)*temp3;
	           d=temp1*temp3;
	           e=c-2*temp3;
	           f=(float) (Math.PI*temp3*temp2);
	           g=(temp2*temp3)/d;
	           b=(d*e)/f;
				
				
				textView4.setText("�����ȣ�"+String.valueOf(a)+
						"\n���ľࣺ"+String.valueOf(b)+
						"\n�����⾶��"+String.valueOf(c)+
						"\n���ֽھ���"+String.valueOf(d)+
						"\n�ϸ˽ھ���"+String.valueOf(e)+
						"\n�ϸ˵��̣�"+String.valueOf(f)+
						"\n�����ǣ�"+String.valueOf(g)
						
						
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
