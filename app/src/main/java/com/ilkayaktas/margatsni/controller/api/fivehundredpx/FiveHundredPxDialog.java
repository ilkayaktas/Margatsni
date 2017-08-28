package com.ilkayaktas.margatsni.controller.api.fivehundredpx;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.ilkayaktas.margatsni.utils.AppConstants;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/**
 * Authentication and authorization dialog.
 * 
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 *
 */
@SuppressLint({ "NewApi", "SetJavaScriptEnabled" })
public class FiveHundredPxDialog extends Dialog {
	private WebView mWebView;
	private LinearLayout mContent;
	private String mAuthUrl;
	private OnApiAuthentication onApiAuthentication;
	private OAuth10aService service;
	private final OAuth1RequestToken requestToken;


	static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
			ViewGroup.LayoutParams.MATCH_PARENT);

	static final String TAG = "500px-Android";

	public FiveHundredPxDialog(Context context, OAuth10aService service, OAuth1RequestToken requestToken, String authUrl, OnApiAuthentication onApiAuthentication) {
		super(context);
		this.onApiAuthentication = onApiAuthentication;
		this.mAuthUrl = authUrl;
		this.service = service;
		this.requestToken = requestToken;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mContent = new LinearLayout(getContext());
		mContent.setOrientation(LinearLayout.VERTICAL);
	        
		setUpTitle();
		setUpWebView();
	        
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		Point outSize = new Point();
		
		int width = 0;
		int height = 0;
		
		double[] dimensions = new double[2];
		        
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			display.getSize(outSize);
			
			width	= outSize.x;
			height	= outSize.y;
		} else {
			width	= display.getWidth();
			height	= display.getHeight();
		}
		
		if (width < height) {
			dimensions[0]	= 0.87 * width;
	        dimensions[1]	= 0.82 * height;
		} else {
			dimensions[0]	= 0.75 * width;
			dimensions[1]	= 0.75 * height;	        
		}
	        
		addContentView(mContent, new FrameLayout.LayoutParams((int) dimensions[0], (int) dimensions[1]));
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		mWebView.destroy();
	}
	
	private void setUpTitle() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	        
	}

	private void setUpWebView() {
		mWebView = new WebView(getContext());
	        
		mWebView.setVerticalScrollBarEnabled(false);
		mWebView.setHorizontalScrollBarEnabled(false);
		mWebView.setWebViewClient(new ApiWebViewClient());
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.loadUrl(mAuthUrl);
		mWebView.setLayoutParams(FILL);
	        
		WebSettings webSettings = mWebView.getSettings();
		
		webSettings.setSavePassword(false);
		webSettings.setSaveFormData(false);
		
		mContent.addView(mWebView);
	}

	public void clearCache() {
		mWebView.clearCache(true);
		mWebView.clearHistory();
		mWebView.clearFormData();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();

	}
	
	private class ApiWebViewClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			Log.d(TAG, "Redirecting URL " + url);
	        	
			if (url.startsWith(AppConstants.FIVEHUNDREDPX_CALBACK_URL)) {

				Uri uri = Uri.parse(url);

				String oauthVerifier = null;
				try {

					oauthVerifier = URLDecoder.decode(uri.getQueryParameter("oauth_verifier"), "UTF-8");
					onApiAuthentication.onSucces(oauthVerifier);

				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				FiveHundredPxDialog.this.dismiss();
	        		
	        	return true;
			}

			return false;
		}

		@Override
		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {	
			super.onReceivedError(view, errorCode, description, failingUrl);

			FiveHundredPxDialog.this.dismiss();
			
			Log.d(TAG, "Page error: " + description);
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			
			Log.d(TAG, "Loading URL: " + url);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			
			Log.d(TAG, "Finished: " + url);
		}
	}
	
	public interface OnApiAuthentication {
		void onSucces(String verifier);
	}
}