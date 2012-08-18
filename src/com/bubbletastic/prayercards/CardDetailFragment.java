package com.bubbletastic.prayercards;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.bubbletastic.prayercards.model.Card;
import com.bubbletastic.prayercards.model.CardTitles;

public class CardDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

    Card mItem;

	private ViewPager viewPager;

    public CardDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = CardTitles.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	
    	CardDetailPagerAdapter adapter = new CardDetailPagerAdapter(CardTitles.CARDS, getActivity().getApplicationContext());
    	
    	setupViewPager();
    	viewPager.setAdapter(adapter);
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
    			Log.d("asdf", "changed to position:"+position);
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
