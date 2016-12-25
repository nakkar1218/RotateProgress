package com.shohei.rotateprogress;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
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

    private final Paint paint = new Paint();
    private ObjectAnimator objectAnimator;

    private int duration = 2000;
    private int[] colors;
    private int index;

    public RotateProgressBar(Context context) {
        this(context, null);
    }

    public RotateProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotateProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(STROKE_WIDTH);
        paint.setStrokeCap(Paint.Cap.ROUND);

        PropertyValuesHolder rotationValuesHolder = PropertyValuesHolder.ofInt("", 0, 360);
        PropertyValuesHolder fadeValuesHolder = PropertyValuesHolder.ofFloat("alpha", 1f, 0f);
        objectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, rotationValuesHolder, fadeValuesHolder);
        objectAnimator.setDuration(duration);
        objectAnimator.setInterpolator(new DecelerateInterpolator());
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.addUpdateListener(valueAnimator -> invalidate());
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                nextColor();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int progress = (Integer) objectAnimator.getAnimatedValue();
        Rect rect = new Rect();
        getDrawingRect(rect);
        RectF rectF = new RectF(
                rect.left + STROKE_WIDTH,
                rect.top + STROKE_WIDTH,
                rect.right - STROKE_WIDTH,
                rect.bottom - STROKE_WIDTH);
        canvas.drawArc(rectF, 0, progress % 360, false, paint);
    }

    /**
     * アニメーションの持続時間を設定
     *
     * @param duration 持続時間
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * プログレスバーで使う色を設定
     *
     * @param colors 色
     */
    public void setColors(int... colors) {
        //TODO カラーコードとColorResを分岐でき出来るようにする
        this.colors = colors;
    }

    /**
     * 次の色を表示
     */
    public void nextColor() {
        index = (index < colors.length - 1) ? index + 1 : 0;
        paint.setColor(colors[index]);
    }

    /**
     * 表示開始
     */
    public void start() {
        objectAnimator.start();
    }
}
