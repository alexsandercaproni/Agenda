package com.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexsandercaproni.unlock4forgotten.MainActivity;
import com.example.alexsandercaproni.unlock4forgotten.R;
import com.control.FragmentCommunicatorSistema;

public class Fragment2 extends Fragment {

    public static Fragment2 newInstance() {
        Fragment2 fragment = new Fragment2();
        return fragment;
    }

    public Fragment2() {
        // Deve existir um construtor vazio
        // na classe que estende um Fragment
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.activity_fragment2, container, false);
        ((MainActivity) getActivity()).passVal(new FragmentCommunicatorSistema() {
            @Override
            public void changeText(String textVal) {
                TextView frv = (TextView) view.findViewById(R.id.msgStatusSistema);
                frv.setText(textVal);
            }

            @Override
            public void changeIV(int imagem) {
                ImageView imageView = (ImageView) view.findViewById(R.id.tvSistema);
                imageView.setImageResource(imagem);
            }
        });
        return view;

    }
}
