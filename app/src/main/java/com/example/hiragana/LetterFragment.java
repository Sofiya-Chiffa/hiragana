package com.example.hiragana;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LetterFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_letter, container, false);
    }

    public void setMessage(String item){
        TextView let = getView().findViewById(R.id.bigLetter);
        let.setText(item);
    }
}
