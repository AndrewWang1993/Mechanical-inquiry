package com.example.clzl1_9;

//import android.app.ListActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//public class cailiaozhongliang extends ListActivity {
//
//	String[] choice = { "棒材重量计算", "管材重量计算","板材重量计算",
//			"角钢重量计算","槽钢重量计算","工字钢重量计算" };
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.cailiaozhongliang);
//		
//		
//		setListAdapter(new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, choice));
//	}
//
//	@Override
//	public void onListItemClick(ListView parent, View v, int position, long id) {
//
//		if (position==0) {
//			Intent intent = new Intent(cailiaozhongliang.this,
//					Bangcai.class);
//			startActivity(intent);
//		}
////		if(position==1){
////			Intent intent = new Intent(cailiaozhongliang.this,
////					gongcha_pianchazhi.class);
////			startActivity(intent);
////		}
////		if(position==2){
////			Intent intent = new Intent(cailiaozhongliang.this,
////					gongcha_pianchazhi.class);
////			startActivity(intent);
////		}
////		if(position==3){
////			Intent intent = new Intent(cailiaozhongliang.this,
////					gongcha_pianchazhi.class);
////			startActivity(intent);
////		}
////		if(position==4){
////			Intent intent = new Intent(cailiaozhongliang.this,
////					gongcha_pianchazhi.class);
////			startActivity(intent);
////		}
////		if(position==5){
////			Intent intent = new Intent(cailiaozhongliang.this,
////					gongcha_pianchazhi.class);
////			startActivity(intent);
//		}
//	}
//		
//	



import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class cailiaozhongliang extends ListActivity {

	String[] choice = { "棒材重量计算", "管材重量计算",
	"角钢重量计算","槽钢重量计算" };

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
			Intent intent = new Intent(cailiaozhongliang.this,
					Bangcai.class);
			startActivity(intent);
		}
		else if(position==1){
			Intent intent = new Intent(cailiaozhongliang.this,
					Guancai.class);
			startActivity(intent);
		}

		else if(position==2){
			Intent intent = new Intent(cailiaozhongliang.this,
					Jiaogang.class);
			startActivity(intent);
		}
		else if(position==3){
			Intent intent = new Intent(cailiaozhongliang.this,
					Caogang.class);
			startActivity(intent);
		}
	
	}
};

