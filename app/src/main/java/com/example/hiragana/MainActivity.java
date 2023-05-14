package com.example.hiragana;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button butLearn;
    private Button butTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butLearn = findViewById(R.id.ButLearnHiragana);
        butTest = findViewById(R.id.ButTestH);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                switch (v.getId()) {
                    case R.id.ButLearnHiragana:
                        i = new Intent(MainActivity.this, LearnActivity.class);
                        startActivity(i);
                        break;
                    case R.id.ButTestH:
                        i = new Intent(MainActivity.this, TestActivity.class);
                        startActivity(i);
                        break;
                    default:
                        return;
                }
            }
        };
        butLearn.setOnClickListener(listener);
        butTest.setOnClickListener(listener);
    }
}