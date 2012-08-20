package com.bubbletastic.prayercards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class CardListActivity extends FragmentActivity implements CardListFragmentCallbacks, CardDetailFragmentCallbacks {

    private boolean mTwoPane;
	private CardDetailFragment detailFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        if (findViewById(R.id.card_detail_container) != null) {
            mTwoPane = true;
        }
        
        if (mTwoPane) {
        	detailFragment = getOrCreateDetailsFragment(0);
        }
    }
    
    private CardDetailFragment getOrCreateDetailsFragment(int position) {
    	if (detailFragment != null) {
    		return detailFragment;
    	}
    	CardDetailFragment newDetailFragment = null;
    	if (getSupportFragmentManager().findFragmentByTag("0") != null) {
    		newDetailFragment = (CardDetailFragment) getSupportFragmentManager().findFragmentByTag("0");
    	} else {
    		Bundle arguments = new Bundle();
    		arguments.putInt(CardDetailFragment.ARG_ITEM_ID, getIntent().getIntExtra(CardDetailFragment.ARG_ITEM_ID, position));
        	
    		newDetailFragment = new CardDetailFragment();
    		newDetailFragment.setArguments(arguments);

    		getSupportFragmentManager().beginTransaction()
    		.add(R.id.card_detail_container, newDetailFragment, "0")
    		.commit();
    	}
    	return newDetailFragment;
    }
        

    @Override
    public void onItemSelected(int position) {
        if (mTwoPane) {
        	detailFragment = getOrCreateDetailsFragment(position);
        	((CardDetailFragmentAccess) detailFragment).setSelectedItem(position);
        } else {
            Intent detailIntent = new Intent(this, CardDetailActivity.class);
            detailIntent.putExtra(CardDetailFragment.ARG_ITEM_ID, position);
            startActivity(detailIntent);
            overridePendingTransition(R.anim.push_in_from_right, R.anim.push_out_to_left);
        }
    }

	@Override
	public void setActivityTitle(String title) {
		setTitle(title);
	}

	@Override
	public void setNewSelection(int position) {
		CardListFragmentAccess cardListFragmentAccess = ((CardListFragmentAccess) getSupportFragmentManager().findFragmentById(R.id.card_list));
		cardListFragmentAccess.setSelectedItem(position);

	}
}
