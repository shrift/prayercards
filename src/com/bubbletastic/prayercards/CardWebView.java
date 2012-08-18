package com.bubbletastic.prayercards;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

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
	public CardWebView(Context context, AttributeSet attrs, int defStyle, boolean privateBrowsing) {
		super(context, attrs, defStyle, privateBrowsing);
	}
	public CardWebView(Context context, Card card) {
		super(context);
		this.card = card;
		init();
	}
	
	@SuppressWarnings("deprecation")
	private void init() {
    	setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0, 0));
    	setVerticalFadingEdgeEnabled(true);
    	setHorizontalFadingEdgeEnabled(true);
		loadUrl(card.fileName);
	}
	
	public String getCardId() {
		return card.id;
	}
	
	public void onViewDestroyed() {
		destroy();
	}
}
