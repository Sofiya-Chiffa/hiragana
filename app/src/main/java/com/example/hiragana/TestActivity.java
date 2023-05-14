package com.example.hiragana;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestActivity extends AppCompatActivity {
    TextView let;
    EditText answer;
    Button bt;

    int correct = 0;
    int k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        List<String> letters = Arrays.asList(
                "あ", "い", "う", "え", "お",
                "か", "き", "く","け", "こ",
                "さ", "し", "す", "せ", "そ",
                "た", "ち", "つ", "て", "と",
                "な", "に", "ぬ", "ね", "の",
                "は", "ひ", "ふ", "へ", "ほ",
                "ま", "み", "む", "め", "も",
                "や", "ゆ", "よ",
                "ら", "り", "る", "れ", "ろ",
                "わ", "を",
                "ん"

        );
        List<String> riddings = Arrays.asList(
                "a", "i", "u", "e", "o",
                "ka", "ki", "ku", "ke", "ko",
                "sa", "shi", "su", "se", "so",
                "ta", "chi", "tu", "te", "to",
                "na", "ni", "nu", "ne", "no",
                "ha", "hi", "fu", "he", "ho",
                "ma", "mi", "mu", "me", "mo",
                "ya", "yu", "yo",
                "ra", "ri", "ru", "re", "ro",
                "wa", "wo",
                "n"

        );


        let = (TextView)findViewById(R.id.bigLetter);
        answer = (EditText)findViewById(R.id.answer);
        bt = (Button)findViewById(R.id.ButAnsw);
        Random random = new Random();
        int right_id = 0;

        List<Integer> list=new ArrayList<Integer>();
        for (int j = 0; j < letters.size(); j++){
            list.add(random.nextInt(letters.size()));}

        View.OnClickListener listener=new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.ButAnsw:
                        if (k == letters.size()){
                            finish();
                        }
                        else{
                        String usan = answer.getText().toString();
                        if (usan.equals(riddings.get(list.get(k)))){
                            correct++;
                        }
                        k += 1;
                        if (k == letters.size()){
                            String res = correct + "/46";
                            let.setText(res);
                            let.setTextSize(100);
                            bt.setText("finish");
                        }
                        else{
                            let.setText(letters.get(list.get(k)));
                        }}
                        break;
                }
            }
        };
        bt.setOnClickListener(listener);


    }
}
