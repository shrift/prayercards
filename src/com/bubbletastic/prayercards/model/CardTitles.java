package com.bubbletastic.prayercards.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.res.Resources;

import com.bubbletastic.prayercards.R;

public class CardTitles {

    public static List<Card> CARDS = new ArrayList<Card>();
    public static Map<String, Card> ITEM_MAP = new HashMap<String, Card>();

    static {
    	
    	Resources res = Resources.getSystem();
    	
        addItem(new Card("1", res.getString(R.string.card_1_title), res.getString(R.string.card_1_filename)));
        addItem(new Card("2", res.getString(R.string.card_2_title), res.getString(R.string.card_2_filename)));
        addItem(new Card("3", res.getString(R.string.card_3_title), res.getString(R.string.card_3_filename)));
        addItem(new Card("4", res.getString(R.string.card_4_title), res.getString(R.string.card_4_filename)));
        addItem(new Card("5", res.getString(R.string.card_5_title), res.getString(R.string.card_5_filename)));
        addItem(new Card("6", res.getString(R.string.card_6_title), res.getString(R.string.card_6_filename)));
        addItem(new Card("7", res.getString(R.string.card_7_title), res.getString(R.string.card_7_filename)));
        addItem(new Card("8", res.getString(R.string.card_8_title), res.getString(R.string.card_8_filename)));
        addItem(new Card("9", res.getString(R.string.card_9_title), res.getString(R.string.card_9_filename)));
        addItem(new Card("10", res.getString(R.string.card_10_title), res.getString(R.string.card_10_filename)));
    }

    private static void addItem(Card item) {
        CARDS.add(item);
        ITEM_MAP.put(item.id, item);
    }
}
