package com.shohei.rotateprogresslibrary;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/**
 * @auther nakayamashohei
 */
public class RotateProgressBar extends View {
    private static final String TAG = RotateProgressBar.class.getSimpleName();
    private static final int STROKE_WIDTH = 10;

    private Paint progressPaint;
    private ValueAnimator animator;

    public RotateProgressBar(Context context) {
        this(context, null);
    }

    public RotateProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotateProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        progressPaint = new Paint();
        progressPaint.setAntiAlias(true);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeWidth(STROKE_WIDTH);
        progressPaint.setColor(Color.BLUE);
        progressPaint.setStrokeCap(Paint.Cap.ROUND);

        animator = ValueAnimator.ofInt(0, 360).setDuration(2000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(valueAnimator -> invalidate());
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int progress = (Integer) animator.getAnimatedValue();
        Rect rect = new Rect();
        getDrawingRect(rect);
        RectF rectF = new RectF(rect.left + STROKE_WIDTH, rect.top + STROKE_WIDTH, rect.right - STROKE_WIDTH, rect.bottom - STROKE_WIDTH);
        canvas.drawArc(rectF, 0, progress % 360, false, progressPaint);
    }
}
