package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomView extends View {

    private View mValue;
    private ImageView mImage;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);



        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ColorOptionsView, 0, 0);
        String titleText = a.getString(R.styleable.ColorOptionsView_titleText);
        int valueColor = a.getColor(R.styleable.ColorOptionsView_valueColor, getResources().getColor(R.color.holo_blue_light));
        a.recycle();

//        setOrientation(LinearLayout.HORIZONTAL);
//        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_color_options, null, false);

//        TextView title = (TextView) getChildAt(0);
//        title.setText(titleText);
//
//        mValue = getChildAt(1);
//        mValue.setBackgroundColor(valueColor);
//
//        mImage = (ImageView) getChildAt(2);
    }

    public CustomView(Context context) {
        this(context, null);
//        createView();
    }

    private void createView() {
        Rect rect = new Rect();
        rect.top = 100;
    }

    public void setValueColor(int color) {
        mValue.setBackgroundColor(color);
    }

    public void setImageVisible(boolean visible) {
        mImage.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

        // more stuff
    }
