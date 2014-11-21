package com.example.llsj1_6;


import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.webkit.WebView;

public class Showhtml extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showhtml);
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//Ç¿ÖÆÎªºáÆÁ  
        Bundle bun=getIntent().getExtras();
        WebView w = (WebView) findViewById(R.id.web);        
        w.loadUrl(bun.getString("URL"));
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.showhtml, menu);
        return true;
    }
    
}
