package com.example.customview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import com.example.customview.widget.TouchEventView;

public class SingleTouchActivity extends Activity {

    SeekBar seekBarRed;
    SeekBar seekBarGreen;
    SeekBar seekBarBlue;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        seekBarRed = findViewById(R.id.red);
        seekBarGreen = findViewById(R.id.green);
        seekBarBlue = findViewById(R.id.blue);
        view = findViewById(R.id.preview);
        config();
    }

    private void config() {
        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                view.setBackgroundColor(Color.rgb(progress, seekBarGreen.getProgress(), seekBarBlue.getProgress()));
                TouchEventView.setColor(progress, seekBarGreen.getProgress(), seekBarBlue.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                view.setBackgroundColor(Color.rgb(seekBarRed.getProgress(), progress, seekBarBlue.getProgress()));
                TouchEventView.setColor(seekBarRed.getProgress(), progress, seekBarBlue.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                view.setBackgroundColor(Color.rgb(seekBarRed.getProgress(), seekBarGreen.getProgress(), progress));
                TouchEventView.setColor(seekBarRed.getProgress(), seekBarGreen.getProgress(), progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    //    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // get pointer index from the event object
//        int pointerIndex = event.getActionIndex();
//
//        // get pointer ID
//        int pointerId = event.getPointerId(pointerIndex);
//
//        // get masked (not specific to a pointer) action
//        int maskedAction = event.getActionMasked();
//
//        switch (maskedAction) {
//
//            case MotionEvent.ACTION_DOWN:
//            case MotionEvent.ACTION_POINTER_DOWN: {
//                // TODO use data
//                break;
//            }
//            case MotionEvent.ACTION_MOVE: { // a pointer was moved
//                // TODO use data
//                break;
//            }
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_POINTER_UP:
//            case MotionEvent.ACTION_CANCEL: {
//                // TODO use data
//                break;
//            }
//        }
////        invalidate();
//        return true;
////        return super.onTouchEvent(event);
//    }
}
