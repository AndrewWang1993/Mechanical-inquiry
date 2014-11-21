package com.example.llsj1_6;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class lianlunsheji extends ListActivity {

	String[] choice = { "常用链传动类型", "链轮主要尺寸、测试力和抗负荷力", "链轮材料和热处理" };

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

		
			Intent intent = new Intent(lianlunsheji.this, Showhtml.class);
			Bundle bun=new Bundle();
			bun.putString("URL", "file:///android_asset/llsj/llsj"
					+ String.valueOf((position+1) +".html"));
	         intent.putExtras(bun);

			startActivityForResult(intent,1);
		
		
	}
};