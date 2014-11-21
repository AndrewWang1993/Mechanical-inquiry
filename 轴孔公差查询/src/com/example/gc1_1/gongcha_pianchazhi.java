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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("SdCardPath")
public class gongcha_pianchazhi extends Activity {

	public double a, b;

	private static final String DATABASE_NAME = "gongcha.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME1 = "zhoukong";

	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		// �����ݿ��һ�����ɵ�ʱ���������������һ�������������������������ݿ��
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gongcha_pianchazhi);

		// ��DatabaseHelperʵ�������Խ�����һ�����ݿ⸴�Ʋ�����
		@SuppressWarnings("unused")
		SQLiteDatabase db1 = mOpenHelper.getReadableDatabase();

		// �������ݿ�
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

		final TextView jieguo2 = (TextView) findViewById(R.id.result2);
		final Button gongchajieguo = (Button) findViewById(R.id.button0102);
		final EditText spc = (EditText) findViewById(R.id.et0201);
		final EditText xpc = (EditText) findViewById(R.id.et0202);
		final EditText cc = (EditText) findViewById(R.id.et0203);

		gongchajieguo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// String[] s = { "A", "B", "C", "D", "E", "F", "G" };
				// jieguo2.setText("����Ҫ��Ĺ�����ǣ�"
				// + s[(int) (Math.floor(Math.random() * 100)) % 7]);

				int top = Integer.valueOf(spc.getText().toString());
				int low = Integer.valueOf(xpc.getText().toString());
				int chicun = Integer.valueOf(cc.getText().toString());

				SQLiteDatabase db = mOpenHelper.getReadableDatabase();
				String col[] = { "gcd", "chicun", "dengji", "top", "low" };
				// ��ѯ����
				try {
					Cursor cur = db.query(TABLE_NAME1, col, "chicun" + "="
							+ chicun + " AND " + "top" + "=" + top + " AND "
							+ "low" + "=" + low, null, null, null,
							"chicun desc"); // ���һ���������������ѯ�������У�ȡ��һ����
					Log.i("sql", "success");
					cur.moveToFirst();

					jieguo2.setText("����Ҫ��Ĺ�����ǣ�" + cur.getString(0));
				} catch (Exception e) {
					e.printStackTrace();
					jieguo2.setText("û���ҵ�����Ҫ��Ĺ������");
				}

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
