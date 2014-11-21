package com.example.zccs1_7;



import com.example.zccs1_7.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Zhoucheng3 extends Activity {
	private static final String[] str = new String[] {
	    "Éî¹µÇòÖá³Ğ", "µ÷ĞÄÇòÖá³Ğ", 
	    "½Ç½Ó´¥Öá³Ğ", 
	    "Ô²Öù¹ö×ÓÖá³Ğ","Ô²×¶¹ö×ÓÖá³Ğ","ËÄµã½Ó´¥ÇòÖá³Ğ",
	    "µ÷ĞÄ¹ö×ÓÖá³Ğ","ÍÆÁ¦ÇòÖá³Ğ","ÍÆÁ¦¹ö×ÓÖá³Ğ","¹öÕëÖá³Ğ" };
private ListView lv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhoucheng3);
        
        lv3 = (ListView) findViewById(R.id.lv3);
		lv3.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, str));
		
		lv3.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
               
               Intent intent = new Intent(Zhoucheng3.this, Zhoucheng3_x.class);
       		Bundle bun=new Bundle();
       		bun.putString("URL", "file:///android_asset/zc/3_"
       				+ String.valueOf((arg2 + 1) +"/"+ String.valueOf((arg2 + 1) 
       						+".html")));
                intent.putExtras(bun);

       		startActivityForResult(intent,1);
			
      
			}
		});
    }
   
		


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.zhoucheng3, menu);
        return true;
    }
    
}
