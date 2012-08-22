package com.bubbletastic.prayercards;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.bubbletastic.prayercards.model.Card;

public class CardDetailFragment extends Fragment implements CardDetailFragmentAccess {

    public static final String ARG_ITEM_ID = "item_id";

    Card currentCard;

	private ViewPager viewPager;

	private CardDetailFragmentCallbacks callbacks;

	private CardDetailPagerAdapter adapter;
	
    private static CardDetailFragmentCallbacks sDummyCallbacks = new CardDetailFragmentCallbacks() {

		@Override
		public void setActivityTitle(String title) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setNewSelection(int position) {
			// TODO Auto-generated method stub
			
		}
    };

    public CardDetailFragment() { }
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof CardDetailFragmentCallbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        callbacks = (CardDetailFragmentCallbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = sDummyCallbacks;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setRetainInstance(true);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
        	int int1 = getArguments().getInt(ARG_ITEM_ID);
            currentCard = PrayerCards.cardTitles.CARDS.get(int1);
            callbacks.setActivityTitle(currentCard.title);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
    	adapter = new CardDetailPagerAdapter(PrayerCards.cardTitles.CARDS, getActivity().getApplicationContext());
    	
    	setupViewPager();
    	viewPager.setAdapter(adapter);
    	viewPager.setCurrentItem(currentCard.id);
    	return viewPager;
    }
    
    private void setupViewPager() {
    	viewPager = new ViewPager(getActivity().getApplicationContext());
    	viewPager.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    	viewPager.setOffscreenPageLimit(2);
    	viewPager.setOnTouchListener(new OnTouchListener() {

    		@Override
    		public boolean onTouch(View v, MotionEvent event) {
    			viewPager.requestDisallowInterceptTouchEvent(false);
    			return false;
    		}
    	});
    	viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

    		@Override
    		public void onPageSelected(int position) {
    			currentCard = adapter.getItemAtPosition(position);
    			callbacks.setActivityTitle(currentCard.title);
    			
    			LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getActivity().getApplicationContext());
    			Intent intent = new Intent("card_changed");
    			intent.putExtra("currentCardPosition", position);
    			localBroadcastManager.sendBroadcast(intent);
    			super.onPageSelected(position);
    		}

    	});
    }
    
    @Override
    public void onDestroy() {
    	viewPager = null;
    	super.onDestroy();
    }

	@Override
	public void setSelectedItem(int position) {
		if (viewPager != null) {
			viewPager.setCurrentItem(position);
		}
	}
}
