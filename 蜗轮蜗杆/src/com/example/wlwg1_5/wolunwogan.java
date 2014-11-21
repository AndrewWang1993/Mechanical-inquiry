package com.example.wlwg1_5;




import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class wolunwogan extends ListActivity {

	String[] choice = { "蜗轮蜗杆几何尺寸计算", "蜗杆的基本尺寸和参数", "蜗杆、涡轮的参数匹配",
			"常用蜗杆的种类、加工原理和特点" };

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

		if(position==0){
			Intent intent = new Intent(wolunwogan.this,
					Chichunjisuan.class);
			startActivity(intent);
		}
		else {
			Intent intent = new Intent(wolunwogan.this, showhtml.class);
			Bundle bun=new Bundle();
			bun.putString("URL", "file:///android_asset/wlwg/wg"
					+ String.valueOf((position) +".html"));
	         intent.putExtras(bun);

			startActivityForResult(intent,1);
		}
		
	}
};