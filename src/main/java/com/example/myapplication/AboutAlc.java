package com.example.myapplication;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutAlc extends AppCompatActivity {

    private WebView mWebview;
    private class IgnoreSSLErrorWebViewClient extends WebViewClient {
        // You can all the class anything

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // When an error occurs, ignore and go on
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mWebview = (WebView)findViewById(R.id.webview);
        mWebview.setWebViewClient(new IgnoreSSLErrorWebViewClient());
        mWebview.setWebChromeClient(new WebChromeClient());
        mWebview.loadUrl("https://andela.com/alc");


    }

}
