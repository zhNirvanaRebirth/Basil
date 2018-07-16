package com.zhwilson.basil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

import com.zhwilson.basil.view.LunchTextView;

public class MainActivity extends AppCompatActivity {
    private LunchTextView lunchTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lunchTextView = findViewById(R.id.text);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(-576.0f, 0.0f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float translationZ = (float) animation.getAnimatedValue();
                lunchTextView.setTranslationZ(translationZ);
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(MainActivity.this, getResources().getString(R.string.paneMode), Toast.LENGTH_SHORT).show();
            }
        });
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.setDuration(500);
        valueAnimator.setStartDelay(500);
        valueAnimator.start();
    }
}
