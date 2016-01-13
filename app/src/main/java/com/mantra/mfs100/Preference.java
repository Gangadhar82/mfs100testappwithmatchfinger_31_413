package com.mantra.mfs100;



import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;

public class Preference extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_icicipreference);
		addPreferencesFromResource(R.xml.config);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.icicipreference, menu);
		MenuInflater inflater = getMenuInflater();
		  inflater.inflate(R.menu.second, menu);
		return true;
	}
}
