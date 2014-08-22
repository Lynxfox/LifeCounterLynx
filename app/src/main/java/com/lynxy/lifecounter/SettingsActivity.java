package com.lynxy.lifecounter;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;
import android.widget.TextView;

public class SettingsActivity extends PreferenceActivity implements
		View.OnClickListener {

	// private Switch mFlipCounterSwitch;
	// private Switch mPoisonCountersSwitch;

	private Switch keepScreenAwakeSwitch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.xml.preferences);

		addPreferencesFromResource(R.xml.preferences);

		ActionBar actionBar = getActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
    }
    public void onClick(View view) {

		switch (view.getId()) {


		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
