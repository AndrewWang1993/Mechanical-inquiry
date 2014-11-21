package com.example.jlj2_7;


import com.example.expandable.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.webkit.WebView;

public class showhtml extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showhtml);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//Ç¿ÖÆÎªºáÆÁ  
        Bundle bun=getIntent().getExtras();
        WebView w = (WebView) findViewById(R.id.web);        
        w.loadUrl(bun.getString("URL"));
    }


   
    
}
