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
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final WebView mypage = (WebView) findViewById(R.id.webview);
        mypage.setWebViewClient(new WebViewClient());
        mypage.loadUrl("http://www.goelakash.wordpress.com");
        mypage.canGoBack();
        mypage.canGoForward();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        int fab_background = R.drawable.refresh;
        fab.setImageResource(fab_background);
        fab.setBackgroundTintList(ColorStateList.valueOf(0x222f2f2f));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mypage.reload();
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
