package com.jpdacruz.appcubicajedireccion.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jpdacruz.appcubicajedireccion.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lista_silos_Fragment extends Fragment {


    public Lista_silos_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_lista_silos_es,container,false);

        return view;
    }
}
