package com.bubbletastic.prayercards.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;

import com.bubbletastic.prayercards.R;

public class CardTitles {

	public CardTitles(Context context) {
		createCards(context);
	}
	
    public List<Card> CARDS = new ArrayList<Card>();

    static {
    }

    private void addItem(Card item) {
        CARDS.add(item);
    }
    
    public void createCards(Context context) {
    	Resources res = context.getResources();
    	
        addItem(new Card(0, res.getString(R.string.card_1_title), res.getString(R.string.card_1_filename)));
        addItem(new Card(1, res.getString(R.string.card_2_title), res.getString(R.string.card_2_filename)));
        addItem(new Card(2, res.getString(R.string.card_3_title), res.getString(R.string.card_3_filename)));
        addItem(new Card(3, res.getString(R.string.card_4_title), res.getString(R.string.card_4_filename)));
        addItem(new Card(4, res.getString(R.string.card_5_title), res.getString(R.string.card_5_filename)));
        addItem(new Card(5, res.getString(R.string.card_6_title), res.getString(R.string.card_6_filename)));
        addItem(new Card(6, res.getString(R.string.card_7_title), res.getString(R.string.card_7_filename)));
        addItem(new Card(7, res.getString(R.string.card_8_title), res.getString(R.string.card_8_filename)));
        addItem(new Card(8, res.getString(R.string.card_9_title), res.getString(R.string.card_9_filename)));
        addItem(new Card(9, res.getString(R.string.card_10_title), res.getString(R.string.card_10_filename)));
    }
}
