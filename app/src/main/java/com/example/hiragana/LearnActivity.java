package com.example.hiragana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Arrays;
import java.util.List;

public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
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
        int ROWS = 11;
        int COLUMNS = 5;
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        LetterFragment fb = new LetterFragment();
        ft.add(R.id.place_holder, fb);
        ft.commit();
        int k = 0;
        for (int i = 0; i < ROWS; i++) {

            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));

            for (int j = 0; j < COLUMNS; j++) {
                if (i == 7 && j >= 3){
                    break;
                }
                if (i == 9 && j >= 2){
                    break;
                }
                if (i == 10 && j >= 1){
                    break;
                }
                Button button = new Button(this);
                button.setText(letters.get(k));
                tableRow.addView(button, j);
                k += 1;
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String let = String.valueOf(button.getText());

                    }
                });
            }

            tableLayout.addView(tableRow, i);
        }
    }
}