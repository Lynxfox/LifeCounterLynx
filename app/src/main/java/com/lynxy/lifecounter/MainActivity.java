package com.lynxy.lifecounter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String SAVED_STATE_PLAYER_1_LIFE = "savedStatePlayer1Life";
    private static final String SAVED_STATE_PLAYER_1_POISON = "savedStatePlayer1Poison";
    private static final String SAVED_STATE_PLAYER_2_LIFE = "savedStatePlayer2Life";
    private static final String SAVED_STATE_PLAYER_2_POISON = "savedStatePlayer2Poison";

    //settings
	private int startingLife= 20;
    //counters
	private int player1Life = startingLife;
	private int player2Life = startingLife;
	private int player1Poison = 0;
	private int player2Poison = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        actionBar.setDisplayShowHomeEnabled(false);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            player1Life = savedInstanceState.getInt(SAVED_STATE_PLAYER_1_LIFE);
            player1Poison = savedInstanceState.getInt(SAVED_STATE_PLAYER_1_POISON);
            player2Life = savedInstanceState.getInt(SAVED_STATE_PLAYER_2_LIFE);
            player2Poison = savedInstanceState.getInt(SAVED_STATE_PLAYER_2_POISON);
            refreshPlayer1Life();
            refreshPlayer2Life();
        } else {
            // We need to load it once here to be able to use it in resetLife() even if we are
            // loading it again in onStart()
           // startingLife = SharedPrefsConfig.getInt(this, SharedPrefsConfig.STARTING_LIFE, 20);
            resetLife();
        }

		findViewById(R.id.player1_life_add).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						player1Life++;
						refreshPlayer1Life();
                    }
				});

        findViewById(R.id.player1_life_remove).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        player1Life--;
                        refreshPlayer1Life();
                    }
                });

        findViewById(R.id.player2_life_add).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        player2Life++;
                        refreshPlayer2Life();
                    }
                });

        findViewById(R.id.player2_life_remove).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        player2Life--;
                        refreshPlayer2Life();
                    }
                });

        findViewById(R.id.reset).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resetLife();
                    }
                });


        refreshPlayer1Life();
		refreshPlayer2Life();

	}

    @Override
    protected void onStart() {
        super.onStart();

        refreshPlayer1Life();
        refreshPlayer2Life();
        //startingLife = SharedPrefsConfig.getInt(this, SharedPrefsConfig.STARTING_LIFE, 20);


        //boolean keepScreenAwake = SharedPrefsConfig.getBoolean(this,
         //       SharedPrefsConfig.KEEP_SCREEN_AWAKE, true);
        //if (keepScreenAwake) {
          //  getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //} else {
          //  getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //}
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
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
		}
	}

	private void refreshPlayer1Life() {
		final TextView textViewToChange = (TextView) findViewById(R.id.player1_life);
		textViewToChange.setText("" + player1Life);
	}

	private void refreshPlayer2Life() {
		final TextView textViewToChange2 = (TextView) findViewById(R.id.player2_life);
		textViewToChange2.setText("" + player2Life);
	}

    private void resetLife(){
        player1Life = startingLife;
        player2Life = startingLife;
        player1Poison = 0;
        player2Poison = 0;
        refreshPlayer1Life();
        refreshPlayer2Life();

    }
}
