package com.zhwilson.basil.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zhwilson.basil.R;

/**
 * Created by zhwilson on 2018/7/16.
 */

public class LunchTextView extends View {
    private static final int TEXT_COLOR = Color.parseColor("#37996F");
    private static final int TEXT_SIZE = 60;
    private int textColorDefault;
    private float textSizeDefault;
    private int textColor;
    private float textSize;
    private String text;
    private Paint paint;
    private int width;
    private int height;
    private float translationZ = -1;
    private Camera camera = new Camera();
    private Matrix matrix;

    public LunchTextView(Context context) {
        this(context, null);
    }

    public LunchTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.LunchTextViewStyle);
    }

    public LunchTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        textColorDefault = TEXT_COLOR;
        textSizeDefault = TEXT_SIZE * context.getResources().getDisplayMetrics().scaledDensity;

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LunchTextView, defStyleAttr, 0);
        text = typedArray.getString(R.styleable.LunchTextView_lunch_text);
        textColor = typedArray.getColor(R.styleable.LunchTextView_lunch_text_color, textColorDefault);
        textSize = typedArray.getDimension(R.styleable.LunchTextView_lunch_text_size, textSizeDefault);
        typedArray.recycle();

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.CENTER);
        if (Build.VERSION.SDK_INT > 21)
            paint.setLetterSpacing(.2f);
        paint.setTypeface(Typeface.createFromAsset(context.getApplicationContext().getAssets(), "fonts/Montserrat-Bold.ttf"));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (translationZ == -1) return;
        canvas.translate(width * 1.0f / 2, height * 1.0f / 2);

        canvas.save();
        if (matrix == null) matrix = new Matrix();
        matrix.reset();
        if (camera == null) camera = new Camera();
        camera.save();
        camera.translate(0, 0, translationZ);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-(width * 1.0f / 2), -(height * 1.0f / 2));
        matrix.preTranslate(width * 1.0f / 2, height * 1.0f / 2);
        canvas.concat(matrix);
        canvas.drawText(text, 0, 0, paint);
        canvas.restore();
    }

    @Override
    public float getTranslationZ() {
        return translationZ;
    }

    @Override
    public void setTranslationZ(float translationZ) {
        this.translationZ = translationZ;
        invalidate();
    }
}
