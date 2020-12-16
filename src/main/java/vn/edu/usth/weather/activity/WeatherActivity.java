package vn.edu.usth.weather.activity;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import vn.edu.usth.weather.R;
import vn.edu.usth.weather.fragment.ForecastFragment;

public class WeatherActivity extends AppCompatActivity {
	public static final String TAG = "WeatherActivity";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate: called");
		setContentView(R.layout.activity_main);

		ForecastFragment forecastFragment = new ForecastFragment();
		getSupportFragmentManager().beginTransaction().add(R.id.forecast_fragment, forecastFragment).commit();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart: called");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume: called");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause: called");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop: called");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy: called");
	}
}
