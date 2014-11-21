package com.example.xwgc1_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class xingweigongcha1_2 extends Activity {

	private int zhonglei = 1;
	private int dengji = 1;
	private Integer chicun = 0;

	private static final String DATABASE_NAME = "jixiezhishi.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME1 = "pingxingdu";
	private static final String TABLE_NAME2 = "zhixiandu";
	private static final String Chicun = "chicu";
	private static final String Gongcha = "gongcha";
	private static final String Key = "key";

	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		// 在数据库第一次生成的时候会调用这个方法，一般我们在这个方法里边生成数据库表。
		@Override
		public void onCreate(SQLiteDatabase db) {

//			String sql1 = "CREATE TABLE " + TABLE_NAME1 + " (" + Chicun
//					+ " integer, " + Gongcha + " integer, " + Key + " float "
//					+ ");";
//			Log.i("haiyang:createDB=", sql1);
//			db.execSQL(sql1);
//			String sql2 = "CREATE TABLE " + TABLE_NAME2 + " (" + Chicun
//					+ " integer, " + Gongcha + " integer, " + Key + " float "
//					+ ");";
//			Log.i("haiyang:createDB=", sql2);
//			db.execSQL(sql2);

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}
	}

	DatabaseHelper mOpenHelper = new DatabaseHelper(this);

	@SuppressLint("SdCardPath")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xingweigongcha);
		
		//将DatabaseHelper实例化，以进行下一步数据库复制操作。
		@SuppressWarnings("unused")
		SQLiteDatabase db1 = mOpenHelper.getReadableDatabase();
		
		// 复制数据库
		try {        	
        	String destPath = "/data/data/" + getPackageName() + "/databases/jixiezhishi.db";
			    CopyDB( getBaseContext().getAssets().open("jixiezhishi.db"), 
					new FileOutputStream(destPath));
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
               
		
		
		final EditText editText1 = (EditText) findViewById(R.id.editText1);
		final Button button1 = (Button) findViewById(R.id.button1);
		final TextView textView6 = (TextView) findViewById(R.id.textView6);

		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.xingweigongcha,
				android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.gongchadengji,
				android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spn1 = (Spinner) findViewById(R.id.spinner1);
		spn1.setAdapter(adapter1);

		Spinner spn2 = (Spinner) findViewById(R.id.spinner2);
		spn2.setAdapter(adapter2);

		spn1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				if (arg2 == 0) {
					zhonglei = 1;
				} else
					zhonglei = 2;

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		spn2.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				dengji = arg2 + 1;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float a = Float.valueOf((editText1.getText().toString()));
				chicun = (int) a;

				if (zhonglei == 1) {
					SQLiteDatabase db = mOpenHelper.getReadableDatabase();
					String col[] = { Gongcha, Chicun, Key };
					// 查询数据
					Cursor cur = db.query(TABLE_NAME1, col, Gongcha + "=" + dengji
							+ " AND " + Chicun + ">" + chicun, null, null, null,
							null);
					cur.moveToFirst();
					textView6.setText("形位公差为："+cur.getString(2)+"μm");
				}
				else{
					SQLiteDatabase db = mOpenHelper.getReadableDatabase();
					String col[] = { Gongcha, Chicun, Key };
					// 查询数据
					Cursor cur = db.query(TABLE_NAME2, col, Gongcha + "=" + dengji
							+ " AND " + Chicun + ">" + chicun, null, null, null,
							null);
					cur.moveToFirst();
					textView6.setText("形位公差为："+cur.getString(2)+"μm");
				}
			}

		});

		



	}

	private void CopyDB(InputStream open, FileOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		byte[] buffer =new byte[1024];
		int length;
		while((length = open.read(buffer))>0){
			out.write(buffer, 0, length);
		}
		open.close();
		out.close();
	}
}
