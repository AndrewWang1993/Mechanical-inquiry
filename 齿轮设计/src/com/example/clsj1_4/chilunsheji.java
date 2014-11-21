package com.example.clsj1_4;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class chilunsheji extends ListActivity {

	String[] choice = { "渐开线圆柱齿轮模数", "外齿轮标准直齿轮计算","斜齿轮（人字齿）计算" };

	// String[] presidents;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, choice));
	}

	@Override
	public void onListItemClick(ListView parent, View v, int position, long id) {

		if (position==0) {
			Intent intent = new Intent(chilunsheji.this,
					Jiankaixian.class);
			startActivity(intent);
		}
		else if(position==1){
			Intent intent = new Intent(chilunsheji.this,
					Zhichilun.class);
			startActivity(intent);
		}
			else{
				Intent intent = new Intent(chilunsheji.this,
						Xiechilun.class);
				startActivity(intent);
		}
	}
};