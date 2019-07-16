package com.example.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

import com.example.customview.R;

public class EmotionalFaceView extends View {

    // Paint object for coloring and styling
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    // Some colors for the face background, eyes and mouth.
    private int faceColor;
    private int eyesColor;
    private int mouthColor;
    private int borderColor;
    // Face border width in pixels
    private float borderWidth;
    // View size in pixels
    private int size;
    // path for mouth
    private Path mouthPath = new Path();
    // default data
    int DEFAULT_FACE_COLOR = Color.YELLOW;
    int DEFAULT_EYES_COLOR = Color.BLACK;
    int DEFAULT_MOUTH_COLOR = Color.BLACK;
    int DEFAULT_BORDER_COLOR = Color.BLACK;
    float DEFAULT_BORDER_WIDTH = 4.0f;
    public static long HAPPY = 0L;
    public static long SAD = 1L;
    long happinessState = HAPPY;

    public EmotionalFaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupAttributes(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawFaceBackground(canvas);
        drawEyes(canvas);
        drawMouth(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        size = MeasureSpec.getSize(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        size = Math.min(widthSize, heightSize);
        setMeasuredDimension(size, size);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
//        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }

    private void drawFaceBackground(Canvas canvas) {
        // 1
        paint.setColor(faceColor);
        paint.setStyle(Paint.Style.FILL);
        // 2
        float radius = size / 2f;
        // 3
        canvas.drawCircle(size / 2f, size / 2f, radius, paint);
        // 4
        paint.setColor(borderColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(borderWidth);
        // 5
        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint);
    }

    private void drawEyes(Canvas canvas) {
        // 1
        paint.setColor(borderColor);
        paint.setStyle(Paint.Style.STROKE);
        // 2
        RectF leftEyeRect = new RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f);
        canvas.drawOval(leftEyeRect, paint);
        // 3
        RectF rightEyeRect = new RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f);
        canvas.drawOval(rightEyeRect, paint);
        // 4
        paint.setColor(eyesColor);
        paint.setStyle(Paint.Style.FILL);
        RectF leftEyeRect2 = new RectF(size * 0.325f, size * 0.32f, size * 0.425f, size * 0.45f);
        canvas.drawOval(leftEyeRect2, paint);
        RectF rightEyeRect2 = new RectF(size * 0.575f, size * 0.32f, size * 0.675f, size * 0.45f);
        canvas.drawOval(rightEyeRect2, paint);
    }

    private void drawMouth(Canvas canvas) {
        mouthPath.reset();
        // 1
        if (happinessState == HAPPY) {
            // Happy mouth path
            mouthPath.moveTo(size * 0.22f, size * 0.65f);
            mouthPath.quadTo(size * 0.5f, size * 0.85f, size * 0.78f, size * 0.65f);
            mouthPath.quadTo(size * 0.5f, size * 1f, size * 0.22f, size * 0.65f);
        } else {
            // Sad mouth path
            mouthPath.moveTo(size * 0.22f, size * 0.75f);
            mouthPath.quadTo(size * 0.5f, size * 0.5f, size * 0.78f, size * 0.75f);
            mouthPath.quadTo(size * 0.5f, size * 0.65f, size * 0.22f, size * 0.75f);
        }
        // 2
        paint.setColor(mouthColor);
        paint.setStyle(Paint.Style.FILL);
        // 3
        canvas.drawPath(mouthPath, paint);
    }

    private void setupAttributes(Context context, AttributeSet attrs) {
        // 1
        // Obtain a typed array of attributes
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EmotionalFaceView, 0, 0);
        // 2
        // Extract custom attributes into member variables
        happinessState = (long)typedArray.getInt(R.styleable.EmotionalFaceView_state, (int)HAPPY);
        faceColor = typedArray.getColor(R.styleable.EmotionalFaceView_faceColor, DEFAULT_FACE_COLOR);
        eyesColor = typedArray.getColor(R.styleable.EmotionalFaceView_eyesColor, DEFAULT_EYES_COLOR);
        mouthColor = typedArray.getColor(R.styleable.EmotionalFaceView_mouthColor, DEFAULT_MOUTH_COLOR);
        borderColor = typedArray.getColor(R.styleable.EmotionalFaceView_borderColor, DEFAULT_BORDER_COLOR);
        borderWidth = typedArray.getDimension(R.styleable.EmotionalFaceView_borderWidth, DEFAULT_BORDER_WIDTH);
        // 3
        // TypedArray objects are shared and must be recycled.
        typedArray.recycle();
    }

    public void setHappinessState(long state) {
        happinessState = state;
        invalidate();
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putLong("happinessState", happinessState);
        bundle.putParcelable("superState", super.onSaveInstanceState());
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        Parcelable viewState = state;
        if (viewState instanceof Bundle) {
            happinessState = ((Bundle)viewState).getLong("happinessState", HAPPY);
            viewState = ((Bundle)viewState).getParcelable("superState");
        }
        super.onRestoreInstanceState(viewState);
    }
}
