package com.example.hiragana;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        Button butClose = (Button) view.findViewById(R.id.close);
        butClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeFr();
            }
        });
        return view;
    }

    public void closeFr(){
        getActivity().getFragmentManager().beginTransaction().hide(this).commit();
    }

    public void openFr(){
        getActivity().getFragmentManager().beginTransaction().show(this).commit();
        Bundle bundle = this.getArguments();
        String i = "";
        if (bundle != null) {
            i = bundle.getString("Let", "");
        }
        String j = "";
        if (bundle != null) {
            j = bundle.getString("Rid", "");
        }
        TextView let = (TextView) getView().findViewById(R.id.bigLetter);
        let.setText(i);
        TextView rid = (TextView) getView().findViewById(R.id.reading);
        rid.setText(j);;
    }
}
