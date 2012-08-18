package com.bubbletastic.prayercards;

import com.bubbletastic.prayercards.model.CardTitles;

import android.app.Application;

public class PrayerCards extends Application {

	public static CardTitles cardTitles;

	@Override
	public void onCreate() {
		super.onCreate();
		cardTitles = new CardTitles(this);
	}
}
