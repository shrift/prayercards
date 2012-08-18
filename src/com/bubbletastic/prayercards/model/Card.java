package com.bubbletastic.prayercards.model;

public class Card {

    public String id;
    public String content;
	public String fileName;

    public Card(String id, String content, String fileName) {
        this.id = id;
        this.content = content;
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return content;
    }
}