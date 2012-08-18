package com.bubbletastic.prayercards;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.bubbletastic.prayercards.model.Card;

public class CardDetailPagerAdapter extends PagerAdapter {

	private List<Card> cards;
	private Context context;

	public CardDetailPagerAdapter(List<Card> cards, Context context) {
		this.cards = cards;
		this.context = context;
	}

	@Override
	public int getCount() {
		return cards.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		CardWebView card  = (CardWebView) object;
		return ((CardWebView) view).getCardId().equals(card.getCardId());
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		CardWebView cardWebView = new CardWebView(context, cards.get(position));
		((ViewPager) container).addView(cardWebView);
		return cardWebView;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager)container).removeView((View)object);
		((CardWebView) object).onViewDestroyed();
	}
}
