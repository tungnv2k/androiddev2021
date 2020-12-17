package vn.edu.usth.weather.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import vn.edu.usth.weather.R;

public class ForecastFragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_forecast, container, false);
		view.setBackgroundColor(Color.WHITE);

		LinearLayout vl = view.findViewById(R.id.vlayout);

		for (int i = 0; i < 5; i++) {
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, 100);
			layoutParams.setMargins(40, 20, 40, 20);

			LinearLayout hl = new LinearLayout(getContext());
			vl.addView(hl, layoutParams);

			TextView thursday = new TextView(getContext());
			thursday.setText(R.string.dow_Thursday);
			hl.addView(thursday, new LinearLayout.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));

			ImageView icon = new ImageView(getContext());
			icon.setImageResource(R.drawable.weather_ico);
			hl.addView(icon, new LinearLayout.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 2f));

			TextView info = new TextView(getContext());
			info.setText(R.string.weather_info);
			hl.addView(info, new LinearLayout.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f));

		}
		return view;
	}
}
