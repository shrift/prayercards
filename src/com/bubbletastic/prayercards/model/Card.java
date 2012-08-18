package com.bubbletastic.prayercards.model;

public class Card {

    public int id;
    public String title;
	public String fileName;

    public Card(int id, String content, String fileName) {
        this.id = id;
        this.title = content;
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return title;
    }
}