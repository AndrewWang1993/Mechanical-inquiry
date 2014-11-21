package com.example.gc1_1;

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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class gongcha_gonchadai extends Activity {

	public double a, b;

	private String gcd = "f";
	private float chicun = 0;
	private int dengji = 5;
	private static final String DATABASE_NAME = "gongcha.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME1 = "zhoukong";

	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		// 在数据库第一次生成的时候会调用这个方法，一般我们在这个方法里边生成数据库表。
		@Override
		public void onCreate(SQLiteDatabase db) {

			// String sql1 = "CREATE TABLE " + TABLE_NAME1 + " (" + Chicun
			// + " integer, " + Gongcha + " integer, " + Key + " float "
			// + ");";
			// Log.i("haiyang:createDB=", sql1);
			// db.execSQL(sql1);
			// String sql2 = "CREATE TABLE " + TABLE_NAME2 + " (" + Chicun
			// + " integer, " + Gongcha + " integer, " + Key + " float "
			// + ");";
			// Log.i("haiyang:createDB=", sql2);
			// db.execSQL(sql2);

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
		setContentView(R.layout.gongcha_gongchadai);

		// 将DatabaseHelper实例化，以进行下一步数据库复制操作。
		 @SuppressWarnings("unused")
		SQLiteDatabase db1 = mOpenHelper.getReadableDatabase();

		// 复制数据库
		try {
			String destPath = "/data/data/" + getPackageName()
					+ "/databases/gongcha.db";
			CopyDB(getBaseContext().getAssets().open("gongcha.db"),
					new FileOutputStream(destPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		final Button chaxun = (Button) findViewById(R.id.button0101);
		final EditText chichun = (EditText) findViewById(R.id.et01);
		final TextView jieguo1 = (TextView) findViewById(R.id.result1);
		final TextView jieguo2 = (TextView) findViewById(R.id.result2);
		final TextView jieguo3 = (TextView) findViewById(R.id.result3);

		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.gongchadai, android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spn1 = (Spinner) findViewById(R.id.spinner01);
		spn1.setAdapter(adapter1);

		spn1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				if (arg2 == 0) {
					gcd = "f";
				} else if (arg2 == 1) {
					gcd = "g";
				} else if (arg2 == 2) {
					gcd = "h";
				} else if (arg2 == 3) {
					gcd = "k";
				} else if (arg2 == 4) {
					gcd = "m";
				} else if (arg2 == 5) {
					gcd = "n";
				} else if (arg2 == 6) {
					gcd = "js";

				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.jingdu, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spn2 = (Spinner) findViewById(R.id.spinner02);
		spn2.setAdapter(adapter2);

		spn2.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				dengji = arg2 + 5;

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		chaxun.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				chicun = Float.valueOf((chichun.getText().toString()));

				SQLiteDatabase db = mOpenHelper.getReadableDatabase();
				String col[] = { "gcd", "chicun", "dengji", "top", "low" };
				// 查询数据

				Cursor cur = db.query(TABLE_NAME1, col, "chicun" + "<" + chicun
						+ " AND " + "dengji" + "=" + dengji + " AND "
						+ "gcd = '" + gcd + "'", null, null, null,
						"chicun desc"); // 最后一个参数表明结果查询倒序排列，取第一个。

				Log.i("tag", "success");
				cur.moveToFirst();

				// a = Math.floor(Math.random() * 10000);
				// b = Math.floor(Math.random() * 10000);
				// if (a % 10 == 0)
				// a++;
				// if (b % 10 == 0)
				// b++;
				// str = chichun.getText().toString() + " +"
				// + String.valueOf(a / 100000) + "-"
				// + String.valueOf(b / 100000);
				// SpannableString msp = new SpannableString(str);
				//
				// msp.setSpan(new SubscriptSpan(), str.indexOf("-"),
				// str.indexOf("-") + 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //
				// 下标
				// msp.setSpan(new SuperscriptSpan(), str.indexOf("+"),
				// str.indexOf("+") + 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //
				// 上标
				//
				// msp.setSpan(new ForegroundColorSpan(Color.RED),
				// str.indexOf("-"), str.indexOf("-") + 8,
				// Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置前景色为洋红色
				// msp.setSpan(new ForegroundColorSpan(Color.RED),
				// str.indexOf("+"), str.indexOf("+") + 8,
				// Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置前景色为洋红色
				//
				// msp.setSpan(new AbsoluteSizeSpan(25), str.indexOf("-"),
				// str.indexOf("-") + 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
				// msp.setSpan(new AbsoluteSizeSpan(25), str.indexOf("+"),
				// str.indexOf("+") + 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

				jieguo1.setText(String.valueOf(chicun));
				jieguo2.setText(String.valueOf(Float.valueOf(cur.getString(3)) / 1000));
				jieguo3.setText(String.valueOf(Float.valueOf(cur.getString(4)) / 1000));

			}
		});

	}

	private void CopyDB(InputStream open, FileOutputStream out)
			throws IOException {
		// TODO Auto-generated method stub
		byte[] buffer = new byte[1024];
		int length;
		while ((length = open.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		open.close();
		out.close();
	}

}
