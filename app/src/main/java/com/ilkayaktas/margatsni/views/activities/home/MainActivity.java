package com.ilkayaktas.margatsni.views.activities.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.ilkayaktas.margatsni.R;
import com.ilkayaktas.margatsni.views.activities.base.BaseActivity;
import com.ilkayaktas.margatsni.views.widgets.dialogs.rateme.Config;
import com.ilkayaktas.margatsni.views.widgets.dialogs.rateme.RateMe;

import javax.inject.Inject;

import butterknife.ButterKnife;
import lib.ilkayaktas.instagram.Instagram;
import lib.ilkayaktas.instagram.InstagramSession;
import lib.ilkayaktas.instagram.model.api.Scope;

public class MainActivity extends BaseActivity implements MainMvpView {

	private InstagramSession mInstagramSession;
	private Instagram mInstagram;

	private ProgressBar mLoadingPb;
	private GridView mGridView;

	@Inject
	MainMvpPresenter<MainMvpView> mPresenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActivityComponent().inject(this);
		
		setUnBinder(ButterKnife.bind(this));
		
		RateMe.init(new Config(5, 10)); // 5 gün ya da 10 defa uygulama başlattıktan sonra
		
		// Attach presenter
		mPresenter.onAttach(MainActivity.this);

		instagram();
	}

	private void instagram() {

		mInstagram  		= new Instagram(this, Scope.ALL);
		mInstagramSession	= mInstagram.getSession();

		mInstagram.authorize();

	}

	@Override
	protected void onStart() {
		super.onStart();
		RateMe.onStart(this);
		RateMe.showRateDialogIfNeeded(this);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		mPresenter.onDetach();
		super.onDestroy();
	}
	
	public static Intent getStartIntent(Context context) {
		Intent intent = new Intent(context, MainActivity.class);
		return intent;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			
			finish();
			
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}
}
