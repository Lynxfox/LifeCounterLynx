package com.lynxy.lifecounter;

import android.app.ActionBar;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class SettingsActivity extends PreferenceActivity implements
		View.OnClickListener {

	// private Switch mFlipCounterSwitch;
	// private Switch mPoisonCountersSwitch;
	private TextView mStartingLifeTextView;

	private Switch mKeepScreenAwakeSwitch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.preferences);

		addPreferencesFromResource(R.xml.preferences);

		ActionBar actionBar = getActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		bindViews();

		populateViews();
	}

	private void bindViews() {
		// mStartingLifeTextView = (TextView)
		// findViewById(R.id.item_starting_life);
		// mStartingLifeTextView.setOnClickListener(this);
		//
		// findViewById(R.id.item_keep_screen_awake).setOnClickListener(this);
		// mKeepScreenAwakeSwitch = (Switch)
		// findViewById(R.id.pref_screen_on_checkbox);

	}

	private void populateViews() {

		// int startingLife = SharedPrefsConfig.getInt(this,
		// SharedPrefsConfig.STARTING_LIFE, 20);
		// mStartingLifeTextView.setText(getString(
		// R.string.settings_item_starting_life_format, startingLife));
		//
		// mKeepScreenAwakeSwitch.setChecked(SharedPrefsConfig.getBoolean(this,
		// SharedPrefsConfig.KEEP_SCREEN_AWAKE, true));
	}

	public void onClick(View view) {

		switch (view.getId()) {

		// case R.id.item_keep_screen_awake:
		// mKeepScreenAwakeSwitch.toggle();
		// SharedPrefsConfig.setBoolean(this,
		// SharedPrefsConfig.KEEP_SCREEN_AWAKE,
		// mKeepScreenAwakeSwitch.isChecked());
		// break;
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
