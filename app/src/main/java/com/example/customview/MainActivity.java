package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBarRed;
    SeekBar seekBarGreen;
    SeekBar seekBarBlue;
    View view;
    EmotionalFaceView mainFace;
    EmotionalFaceView happyButton;
    EmotionalFaceView sadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        mainFace = findViewById(R.id.emotionalFaceView);
        happyButton = findViewById(R.id.happyButton);
        sadButton = findViewById(R.id.sadButton);
        // 1
        happyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFace.setHappinessState(EmotionalFaceView.HAPPY);
            }
        });
        // 2
        sadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFace.setHappinessState(EmotionalFaceView.SAD);
            }
        });
//        seekBarRed = findViewById(R.id.red);
//        seekBarGreen = findViewById(R.id.green);
//        seekBarBlue = findViewById(R.id.blue);
//        view = findViewById(R.id.preview);

//        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                view.setBackgroundColor(Color.rgb(progress, seekBarGreen.getProgress(), seekBarBlue.getProgress()));
//                TouchEventView.setColor(progress, seekBarGreen.getProgress(), seekBarBlue.getProgress());
//            }
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//            }
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//            }
//        });
//
//        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                view.setBackgroundColor(Color.rgb(seekBarRed.getProgress(), progress, seekBarBlue.getProgress()));
//                TouchEventView.setColor(seekBarRed.getProgress(), progress, seekBarBlue.getProgress());
//            }
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//            }
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//            }
//        });
//
//        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                view.setBackgroundColor(Color.rgb(seekBarRed.getProgress(), seekBarGreen.getProgress(), progress));
//                TouchEventView.setColor(seekBarRed.getProgress(), seekBarGreen.getProgress(), progress);
//            }
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//            }
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//            }
//        });

    }

    public void onClicked(View view) {
        String text = view.getId() == R.id.view1 ? "Background" : "Foreground";
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
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
