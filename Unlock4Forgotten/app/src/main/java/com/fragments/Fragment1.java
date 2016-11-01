package com.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.control.FragmentCommunicatorPortaFechada;
import com.example.alexsandercaproni.unlock4forgotten.MainActivity;
import com.example.alexsandercaproni.unlock4forgotten.R;
import com.control.FragmentCommunicatorPorta;

public class Fragment1 extends Fragment {

    public static Fragment1 newInstance() {
        Fragment1 fragment = new Fragment1();
        return fragment;
    }

    public Fragment1() {
        // Deve existir um construtor vazios
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
        final View view = inflater.inflate(R.layout.activity_fragment1, container, false);
        ((MainActivity) getActivity()).passVal(new FragmentCommunicatorPorta() {
            @Override
            public void changeText(String textVal) {
                TextView frv = (TextView) view.findViewById(R.id.msgStatusPorta);
                frv.setText(textVal);
            }

            @Override
            public void changeIV(int imagem) {
                ImageView imageView = (ImageView) view.findViewById(R.id.tvPorta);
                imageView.setImageResource(imagem);
            }
        });

        ((MainActivity) getActivity()).passVal(new FragmentCommunicatorPortaFechada() {
            @Override
            public void changeText(String textVal) {
                TextView frv = (TextView) view.findViewById(R.id.msgStatusPorta);
                frv.setText(textVal);
            }

            @Override
            public void changeIV(int imagem) {
                ImageView imageView = (ImageView) view.findViewById(R.id.tvPorta);
                imageView.setImageResource(imagem);
            }
        });

        return view;

        //return inflater.inflate(R.layout.activity_fragment1, container, false);
    }


}
