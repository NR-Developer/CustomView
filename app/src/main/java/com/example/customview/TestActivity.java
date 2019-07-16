package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TestActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
        // Create a LinearLayout in which to add the ImageView
        linearLayout = new LinearLayout(this);

        // Instantiate an ImageView and define its properties
        ImageView i = new ImageView(this);
        i.setImageResource(R.drawable.ic_launcher_foreground);

        // set the ImageView bounds to match the Drawable's dimensions
        i.setAdjustViewBounds(true);
        i.setLayoutParams(new Gallery.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        // Add the ImageView to the layout and set the layout as the content view
        linearLayout.addView(i);
        setContentView(linearLayout);

    }
}
