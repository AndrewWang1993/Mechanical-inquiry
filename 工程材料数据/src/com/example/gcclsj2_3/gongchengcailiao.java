package com.example.gcclsj2_3;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class gongchengcailiao extends ListActivity {

	String[] choice = {  "¸Ö²Ä", "ÖýÌú","Öý¸Ö","¹¤³ÌËÜÁÏ"  };

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

		
			Intent intent =new Intent( gongchengcailiao.this,
					Showhtml.class);
			Bundle bun=new Bundle();
			bun.putString("URL", "file:///android_asset/gccl/gccl"
					+ String.valueOf((position + 1) 
						+".html"));
	         intent.putExtras(bun);
			
			startActivity(intent);
		

	}
};