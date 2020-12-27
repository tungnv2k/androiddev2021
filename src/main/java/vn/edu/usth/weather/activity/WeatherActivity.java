package vn.edu.usth.weather.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import vn.edu.usth.weather.R;
import vn.edu.usth.weather.adapter.HomeFragmentPagerAdapter;

import java.io.*;
import java.util.Locale;

public class WeatherActivity extends AppCompatActivity {
	public static final String TAG = "WeatherActivity";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate: called");
		setContentView(R.layout.activity_main);

		handleSoundFile();
		playSoundFile();

		PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(), 1);
		ViewPager pager = findViewById(R.id.pager);
		pager.setOffscreenPageLimit(3);
		pager.setAdapter(adapter);
		pager.setCurrentItem(1);
	}

	private void playSoundFile() {
		MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.mp3_sound);
		mediaPlayer.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			mediaPlayer.stop();
		}
	}

	private void handleSoundFile() {
		File sdCard = Environment.getExternalStorageDirectory();
		File dir = new File(sdCard.getAbsolutePath() + "/tempdev");
		dir.mkdirs();
		File file = new File(dir, "mp3_sound.mp3");

		try (InputStream mp3Input = this.getResources().openRawResource(R.raw.mp3_sound);
		     OutputStream sdCardOutput = new FileOutputStream(file)) {
			byte[] buffer = new byte[4 * 1024];
			int read;

			while ((read = mp3Input.read(buffer)) != -1) {
				sdCardOutput.write(buffer, 0, read);
			}

			sdCardOutput.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
