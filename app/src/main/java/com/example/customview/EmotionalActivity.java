package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.customview.widget.EmotionalFaceView;

public class EmotionalActivity extends AppCompatActivity {

    EmotionalFaceView mainFace;
    EmotionalFaceView happyButton;
    EmotionalFaceView sadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotional);

        mainFace = findViewById(R.id.emotionalFaceView);
        happyButton = findViewById(R.id.happyButton);
        sadButton = findViewById(R.id.sadButton);

        actions();
    }

    private void actions() {
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
    }
}
