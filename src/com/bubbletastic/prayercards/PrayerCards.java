package com.bubbletastic.prayercards;

import android.app.Application;

import com.bubbletastic.prayercards.model.CardTitles;

public class PrayerCards extends Application {

	public static CardTitles cardTitles;
	public static Integer DEVICE_SDK_VERSION;

	@Override
	public void onCreate() {
		super.onCreate();
		DEVICE_SDK_VERSION = Integer.valueOf(android.os.Build.VERSION.SDK_INT);
		cardTitles = new CardTitles(this);
	}
}
