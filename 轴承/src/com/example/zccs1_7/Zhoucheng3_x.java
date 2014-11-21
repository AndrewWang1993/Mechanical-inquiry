package com.example.zccs1_7;

import com.example.zccs1_7.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.webkit.WebView;

public class Zhoucheng3_x extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhoucheng3_x);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//Ç¿ÖÆÎªºáÆÁ  

        Bundle bun=getIntent().getExtras();
        WebView w = (WebView) findViewById(R.id.web);        
        w.loadUrl(bun.getString("URL"));
    }
}
