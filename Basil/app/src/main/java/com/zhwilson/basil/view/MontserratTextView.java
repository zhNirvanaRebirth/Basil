package com.zhwilson.basil.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by mshz on 2018/7/11.
 */

public class MontserratTextView extends AppCompatTextView {
    public MontserratTextView(Context context) {
        this(context, null);
    }

    public MontserratTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MontserratTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setTypeface(Typeface.createFromAsset(context.getApplicationContext().getAssets(), "fonts/Montserrat-Bold.ttf"));
    }

}
