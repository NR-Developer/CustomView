package com.example.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.customview.widget.EmotionalFaceView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclickBTN(View view) {
        switch (view.getId()) {
            case R.id.btnClock:
                startActivity(new Intent(this, ClockActivity.class));
                break;
            case R.id.btnEmotional:
                startActivity(new Intent(this, EmotionalActivity.class));
                break;
            case R.id.btnSingleTouch:
                startActivity(new Intent(this, SingleTouchActivity.class));
                break;
        }
    }
}
