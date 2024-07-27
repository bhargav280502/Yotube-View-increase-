package com.example.justview;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private WebView webView1, webView2, webView3, webView4, webView5, webView6, webView7, webView8;
    private TextView countdownTextView;
    private LinearLayout twoscreen, fourscreen, sixscreen, eightscreen;
    private String embedUrl;
    RelativeLayout ggsd;
    private long interval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        webView1 = findViewById(R.id.webView1);
        webView2 = findViewById(R.id.webView2);
        webView3 = findViewById(R.id.webView3);
        webView4 = findViewById(R.id.webView4);
        webView5 = findViewById(R.id.webView5);
        webView6 = findViewById(R.id.webView6);
        webView7 = findViewById(R.id.webView7);
        webView8 = findViewById(R.id.webView8);
        ggsd = findViewById(R.id.ggsd);

        twoscreen = findViewById(R.id.twoscreen);
        fourscreen = findViewById(R.id.fourscreen);
        sixscreen = findViewById(R.id.sixscreen);
        eightscreen = findViewById(R.id.Eightscreen);

        countdownTextView = findViewById(R.id.countdownTextView);

        ggsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nothing doing
            }
        });
        
        String youtubeLink = getIntent().getStringExtra("YOUTUBE_LINK");
        embedUrl = youtubeLink.replace("watch?v=", "embed/");
        Integer tabview = getIntent().getIntExtra("NUMBER_OF_WEBVIEWS", 0);
        interval = getIntent().getIntExtra("INTERVAL", 150000);

        if (tabview == 2) {
            setupWebView(webView1, embedUrl);
            setupWebView(webView2, embedUrl);
            fourscreen.setVisibility(View.GONE);
            sixscreen.setVisibility(View.GONE);
            eightscreen.setVisibility(View.GONE);

        } else if (tabview == 4) {
            setupWebView(webView1, embedUrl);
            setupWebView(webView2, embedUrl);
            setupWebView(webView3, embedUrl);
            setupWebView(webView4, embedUrl);
            sixscreen.setVisibility(View.GONE);
            eightscreen.setVisibility(View.GONE);

        } else if (tabview == 6) {
            setupWebView(webView1, embedUrl);
            setupWebView(webView2, embedUrl);
            setupWebView(webView3, embedUrl);
            setupWebView(webView4, embedUrl);
            setupWebView(webView5, embedUrl);
            setupWebView(webView6, embedUrl);
            eightscreen.setVisibility(View.GONE);

        } else if (tabview == 8) {
            setupWebView(webView1, embedUrl);
            setupWebView(webView2, embedUrl);
            setupWebView(webView3, embedUrl);
            setupWebView(webView4, embedUrl);
            setupWebView(webView5, embedUrl);
            setupWebView(webView6, embedUrl);
            setupWebView(webView7, embedUrl);
            setupWebView(webView8, embedUrl);
        }

        startCountdownTimer();
    }

    private void setupWebView(WebView webView, String url) {
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    private void startCountdownTimer() {
        new CountDownTimer(interval, 1000) {
            public void onTick(long millisUntilFinished) {
                long minutes = (millisUntilFinished / 1000) / 60;
                long seconds = (millisUntilFinished / 1000) % 60;
                String timeFormatted = String.format("%02d:%02d", minutes, seconds);
                countdownTextView.setText("VIDEO REPEAT IN " + timeFormatted + " MINUTES");
            }

            public void onFinish() {
                reloadWebViews();
                startCountdownTimer();
            }
        }.start();
    }

    private void reloadWebViews() {
        webView1.loadUrl(embedUrl);
        webView2.loadUrl(embedUrl);
        webView3.loadUrl(embedUrl);
        webView4.loadUrl(embedUrl);
        webView5.loadUrl(embedUrl);
        webView6.loadUrl(embedUrl);
        webView7.loadUrl(embedUrl);
        webView8.loadUrl(embedUrl);
    }
}
