package com.bubbletastic.prayercards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class CardListActivity extends FragmentActivity implements CardListFragmentAccess {

    private boolean mTwoPane;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        if (findViewById(R.id.card_detail_container) != null) {
            mTwoPane = true;
            ((CardListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.card_list))
                    .setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putString(CardDetailFragment.ARG_ITEM_ID, id);
            CardDetailFragment fragment = new CardDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.card_detail_container, fragment)
                    .commit();

        } else {
            Intent detailIntent = new Intent(this, CardDetailActivity.class);
            detailIntent.putExtra(CardDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
