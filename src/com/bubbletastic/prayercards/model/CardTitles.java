package com.bubbletastic.prayercards.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CardTitles {

    public static List<Card> CARDS = new ArrayList<Card>();
    public static Map<String, Card> ITEM_MAP = new HashMap<String, Card>();

    static {
        addItem(new Card("1", "Item 1", "asdf"));
        addItem(new Card("2", "Item 2", "asdf"));
        addItem(new Card("3", "Item 3", "asdf"));
        addItem(new Card("4", "Item 3", "asdf"));
        addItem(new Card("5", "Item 3", "asdf"));
        addItem(new Card("6", "Item 3", "asdf"));
        addItem(new Card("7", "Item 3", "asdf"));
        addItem(new Card("8", "Item 3", "asdf"));
        addItem(new Card("9", "Item 3", "asdf"));
        addItem(new Card("10", "Item 3", "asdf"));
    }

    private static void addItem(Card item) {
        CARDS.add(item);
        ITEM_MAP.put(item.id, item);
    }
}
