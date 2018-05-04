package com.github.anzewei.sample.basic;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.github.anzewei.parallaxbacklayout.ParallaxBack;
import com.github.anzewei.sample.R;

@ParallaxBack(edge = ParallaxBack.Edge.LEFT, edgeMode = ParallaxBack.EdgeMode.FULLSCREEN)
public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.view_pager);

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                AppCompatTextView textView = new AppCompatTextView(container.getContext());
                textView.setText("Position: " + position);
                textView.setBackgroundColor(Color.WHITE);
                textView.setGravity(Gravity.CENTER);
                container.addView(textView);
                return textView;
            }
        });
    }
}
