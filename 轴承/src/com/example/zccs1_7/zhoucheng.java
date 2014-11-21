package com.example.zccs1_7;


import com.example.zccs1_7.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class zhoucheng extends Activity {

	private static final String[] str = new String[] {
		    "轴承常用前置代码解释", "新旧轴承代号对照表", 
		    "通用滚动轴承的结构与特性"};
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhoucheng);
		
		lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, str));

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if(arg2==0)
				{
				Intent intent = new Intent(zhoucheng.this,
						Zhoucheng1.class);
				startActivity(intent);
				}
				if(arg2==1)
				{
					Intent intent=new Intent(zhoucheng.this,
							Zhoucheng2.class);
							startActivity(intent);
				}
				if(arg2==2)
				{
					Intent intent=new Intent(zhoucheng.this,
							Zhoucheng3.class);
					startActivity(intent);
					onDestroy();
				}

			}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
