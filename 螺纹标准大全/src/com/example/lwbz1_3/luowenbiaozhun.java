package com.example.lwbz1_3;

import com.example.dsf.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.webkit.WebView;

public class luowenbiaozhun extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		  setContentView(R.layout.showhtml);
	        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//Ç¿ÖÆÎªºáÆÁ  
	        WebView w = (WebView) findViewById(R.id.web);        
	        w.loadUrl("file:///android_asset/lwbz.html");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
