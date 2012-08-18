package com.bubbletastic.prayercards;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.bubbletastic.prayercards.model.Card;

public class CardDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

    Card currentCard;

	private ViewPager viewPager;

	private CardDetailFragmentAccess callbacks;

	private CardDetailPagerAdapter adapter;
	
    private static CardDetailFragmentAccess sDummyCallbacks = new CardDetailFragmentAccess() {

		@Override
		public void setActivityTitle(String title) {
			// TODO Auto-generated method stub
			
		}
    };

    public CardDetailFragment() { }
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof CardDetailFragmentAccess)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        callbacks = (CardDetailFragmentAccess) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = sDummyCallbacks;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    			super.onPageSelected(position);
    		}

    	});
    }
    
    @Override
    public void onDestroy() {
    	viewPager = null;
    	super.onDestroy();
    }
}
