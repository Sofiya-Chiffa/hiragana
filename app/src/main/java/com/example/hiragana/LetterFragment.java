package com.example.hiragana;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LetterFragment extends Fragment  {
    public static LetterFragment newInstance(String someString) {
        LetterFragment letterFragment = new LetterFragment();
        Bundle args = new Bundle();
        args.putString("SomeString", someString);
        letterFragment.setArguments(args);
        return letterFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_letter,
                container, false);
        Bundle bundle = this.getArguments();
        String i = "";
        if (bundle != null) {
            i = bundle.getString("Let", "");
        }
        TextView let = (TextView) view.findViewById(R.id.bigLetter);
        let.setText(i);
        return view;
    }
}
