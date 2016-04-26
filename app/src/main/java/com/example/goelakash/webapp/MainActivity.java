package com.example.goelakash.webapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WebView mypage = (WebView) findViewById(R.id.webview);
        mypage.setWebViewClient(new WebViewClient());
        mypage.loadUrl("https://www.quora.com");
        mypage.canGoBack();
        mypage.canGoForward();

        WebSettings mypageSettings = mypage.getSettings();
        mypageSettings.setJavaScriptEnabled(true);

        FloatingActionButton back_button = (FloatingActionButton) findViewById(R.id.back);
        int back_icon = R.drawable.back;
        back_button.setImageResource(back_icon);
        back_button.setBackgroundTintList(ColorStateList.valueOf(0x222f2f2f));
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mypage.goBack();
            }
        });

        FloatingActionButton refresh_button = (FloatingActionButton) findViewById(R.id.refresh);
        int refresh_icon = R.drawable.refresh;
        refresh_button.setImageResource(refresh_icon);
        refresh_button.setBackgroundTintList(ColorStateList.valueOf(0x222f2f2f));
        refresh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mypage.reload();
            }
        });

        FloatingActionButton forward_button = (FloatingActionButton) findViewById(R.id.forward);
        int forward_icon = R.drawable.forward;
        forward_button.setImageResource(forward_icon);
        forward_button.setBackgroundTintList(ColorStateList.valueOf(0x222f2f2f));
        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mypage.goForward();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
