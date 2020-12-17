package vn.edu.usth.weather.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import vn.edu.usth.weather.R;
import vn.edu.usth.weather.adapter.HomeFragmentPagerAdapter;

import java.util.Locale;

public class WeatherActivity extends AppCompatActivity {
	public static final String TAG = "WeatherActivity";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate: called");
		setApplicationLocale("vi");
		setContentView(R.layout.activity_main);

		PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(), 1);
		ViewPager pager = findViewById(R.id.pager);
		pager.setOffscreenPageLimit(3);
		pager.setAdapter(adapter);
		pager.setCurrentItem(1);
	}

	@SuppressWarnings("deprecated")
	private void setApplicationLocale(String locale) {
		Resources resources = getResources();
		DisplayMetrics dm = resources.getDisplayMetrics();
		Configuration config = resources.getConfiguration();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			config.setLocale(new Locale(locale.toLowerCase()));
		} else {
			config.locale = new Locale(locale.toLowerCase());
		}
		resources.updateConfiguration(config, dm);
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
