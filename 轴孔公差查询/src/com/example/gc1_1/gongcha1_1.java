package com.example.gc1_1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class gongcha1_1 extends ListActivity {

	String[] choice = { "���������ѯƫ��ֵ", "��ƫ��ֵѡ�񹫲��", };

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

		if (choice[position].toString().equalsIgnoreCase("���������ѯƫ��ֵ")) {
			Intent intent = new Intent(gongcha1_1.this,
					gongcha_gonchadai.class);
			startActivity(intent);
		}
		else if(choice[position].toString().equalsIgnoreCase("��ƫ��ֵѡ�񹫲��")){
			Intent intent = new Intent(gongcha1_1.this,
					gongcha_pianchazhi.class);
			startActivity(intent);
		}
	}
};