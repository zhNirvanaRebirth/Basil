package com.zhwilson.basil.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by mshz on 2018/7/11.
 */

public class LektonTextView extends AppCompatTextView {
    public LektonTextView(Context context) {
        this(context, null);
    }

    public LektonTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LektonTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setTypeface(Typeface.createFromAsset(context.getApplicationContext().getAssets(), "fonts/Lekton-Bold.ttf"));
    }
}
