package com.example.clsj1_4;

import com.example.chi.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.webkit.WebView;

public class Jiankaixian extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jiankaixian);
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//Ç¿ÖÆÎªºáÆÁ  
        WebView w = (WebView) findViewById(R.id.web);        
        w.loadUrl("file:///android_asset/clsj/jiankaixian.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jiankaixian, menu);
		return true;
	}

}
