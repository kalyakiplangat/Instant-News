package com.thekalya.instantnews.ui.detailnews

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.thekalya.instantnews.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initWebView()

        MobileAds.initialize(this){}
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    private fun initWebView() {
        val url = intent.getStringExtra("url")

        val webView = webView
        val webSetting = webView.settings
        webSetting.javaScriptEnabled = true
        webView.webViewClient= WebViewClient()
        webView.loadUrl(url)

        webView.webViewClient = object: WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar2.visibility = View.GONE
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar2.visibility = View.VISIBLE
            }
        }

    }
}