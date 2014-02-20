package com.lynxy.lifecounter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int startingLife = 20;
	private int player1Life = startingLife;
	private int player2Life = startingLife;
	private int player1Poison = 0;
	private int player2Poison = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		if (savedInstanceState != null) {
			onRestoreInstanceState(savedInstanceState);
		}

		TextView tV1 = (TextView) findViewById(R.id.textView1);
		TextView tV2 = (TextView) findViewById(R.id.textView2);
		Button p1m5 = (Button) findViewById(R.id.p1minus5);
		Button p1p1 = (Button) findViewById(R.id.p1plus1);
		Button p1p5 = (Button) findViewById(R.id.p1plus5);
		Button p2m5 = (Button) findViewById(R.id.p2minus5);
		Button p2p1 = (Button) findViewById(R.id.p2plus1);
		Button p2p5 = (Button) findViewById(R.id.p2plus5);

		Typeface typeFace = Typeface.createFromAsset(getAssets(),
				"fonts/Roboto-Thin.ttf");
		tV1.setTypeface(typeFace);
		tV2.setTypeface(typeFace);
		p1m5.setTypeface(typeFace);
		p1p1.setTypeface(typeFace);
		p1p5.setTypeface(typeFace);
		p2m5.setTypeface(typeFace);
		p2p1.setTypeface(typeFace);
		p2p5.setTypeface(typeFace);

		findViewById(R.id.textView1).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player1Life--;
						if (player1Life < 0) {
							player1Life = 0;
						}
						refreshPlayer1Life();

					}
				});

		findViewById(R.id.textView2).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player2Life--;
						if (player2Life < 0) {
							player2Life = 0;
						}
						refreshPlayer2Life();
					}
				});

		findViewById(R.id.p1poison).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player1Poison++;

						refreshPlayer1Life();
					}
				});
		findViewById(R.id.p2poison).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player2Poison++;

						refreshPlayer2Life();
					}
				});
		findViewById(R.id.p1minus5).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player1Life -= 5;
						if (player1Life < 0) {
							player1Life = 0;
						}
						refreshPlayer1Life();
					}
				});

		findViewById(R.id.p2minus5).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player2Life -= 5;
						if (player2Life < 0) {
							player2Life = 0;
						}
						refreshPlayer2Life();
					}
				});

		findViewById(R.id.p1plus1).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player1Life += 1;
						refreshPlayer1Life();
					}
				});

		findViewById(R.id.p2plus1).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player2Life += 1;
						refreshPlayer2Life();
					}
				});

		findViewById(R.id.p1plus5).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player1Life += 5;
						refreshPlayer1Life();
					}
				});

		findViewById(R.id.p2plus5).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player2Life += 5;
						refreshPlayer2Life();
					}
				});

		refreshPlayer1Life();
		refreshPlayer2Life();

	}

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {

		savedInstanceState.putInt("Player1Life", player1Life);
		savedInstanceState.putInt("Player2Life", player2Life);
		savedInstanceState.putInt("Player1Poison", player1Poison);
		savedInstanceState.putInt("Player2Poison", player2Poison);
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		// Restore UI state from the savedInstanceState.
		// This bundle has also been passed to onCreate.
		player1Life = savedInstanceState.getInt("Player1Life");
		player2Life = savedInstanceState.getInt("Player2Life");
		player1Poison = savedInstanceState.getInt("Player1Poison");
		player2Poison = savedInstanceState.getInt("Player2Poison");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.action_reset:
			player1Life = startingLife;
			player2Life = startingLife;
			player1Poison = 0;
			player2Poison = 0;
			refreshPlayer1Life();
			refreshPlayer2Life();
			return true;

		case R.id.action_settings:
			Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			return true;

			// case R.id.action_2Hgiant:
			//
			// item.setChecked(true);
			// startingLife = 30;
			// player1Life = startingLife;
			// player2Life = startingLife;
			// player1Poison = 0;
			// player2Poison = 0;
			// poisonMax = 15;
			// refreshPlayer1Life();
			// refreshPlayer2Life();
			//
			// return true;
			// case R.id.action_commander:
			// item.setChecked(true);
			// startingLife = 40;
			// player1Life = startingLife;
			// player2Life = startingLife;
			// player1Poison = 0;
			// player2Poison = 0;
			// poisonMax = 10;
			// refreshPlayer1Life();
			// refreshPlayer2Life();
			//
			// return true;
			// // case R.id.action_normal:
			// // item.setChecked(true);
			// // startingLife = 20;
			// // player1Life = startingLife;
			// // player2Life = startingLife;
			// // player1Poison = 0;
			// // player2Poison = 0;
			// // poisonMax = 10;
			// // refreshPlayer1Life();
			// // refreshPlayer2Life();
			//
			// return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void refreshPlayer1Life() {
		final TextView textViewToChange = (TextView) findViewById(R.id.textView1);
		textViewToChange.setText("" + player1Life + "/" + player1Poison);
	}

	private void refreshPlayer2Life() {
		final TextView textViewToChange2 = (TextView) findViewById(R.id.textView2);
		textViewToChange2.setText("" + player2Life + "/" + player2Poison);
	}
}
