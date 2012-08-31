package com.bubbletastic.prayercards;

import java.lang.reflect.Field;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.ZoomButtonsController;

import com.bubbletastic.prayercards.model.Card;

public class CardWebView extends WebView {

	private Card card;

	public CardWebView(Context context) {
		super(context);
	}
	public CardWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public CardWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	public CardWebView(Context context, Card card) {
		super(context);
		this.card = card;
		init();
	}
	
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	private void init() {
		setBackgroundColor(getResources().getColor(android.R.color.white));
    	setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0, 0));
    	getSettings().setSupportZoom(true);
    	getSettings().setBuiltInZoomControls(true);
    	if (PrayerCards.DEVICE_SDK_VERSION >= Build.VERSION_CODES.HONEYCOMB) {
    		getSettings().setDisplayZoomControls(false);
    	} else {
    		setZoomControlGone(this);
    	}
		loadUrl("file:///android_asset/"+card.fileName);
	}
	
	private void setZoomControlGone(View view){
	    Class<?> classType;
	    Field field;
	    try {
	        classType = WebView.class;
	        field = classType.getDeclaredField("mZoomButtonsController");
	        field.setAccessible(true);
	        ZoomButtonsController mZoomButtonsController = new ZoomButtonsController(view);
	        mZoomButtonsController.getZoomControls().setVisibility(View.GONE);
	        try {
	            field.set(view, mZoomButtonsController);
	        } catch (IllegalArgumentException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        }
	    } catch (SecurityException e) {
	        e.printStackTrace();
	    } catch (NoSuchFieldException e) {
	        e.printStackTrace();
	    }
	}
	
	public int getCardId() {
		return card.id;
	}
	
	public void onViewDestroyed() {
		destroy();
	}
}
