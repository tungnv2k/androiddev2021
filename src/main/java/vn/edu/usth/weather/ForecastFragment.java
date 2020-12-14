package vn.edu.usth.weather;

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

public class ForecastFragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.forecast_fragment, container, false);
		view.setBackgroundColor(Color.WHITE);

		LinearLayout ll = view.findViewById(R.id.linlayout);
		ll.setOrientation(LinearLayout.VERTICAL);

		TextView thursday = new TextView(getContext());
		thursday.setText("Thursday");
		ll.addView(thursday);

		ImageView icon = new ImageView(getContext());
		icon.setImageResource(R.drawable.weather_ico);
		ll.addView(icon);

		return view;
	}
}
