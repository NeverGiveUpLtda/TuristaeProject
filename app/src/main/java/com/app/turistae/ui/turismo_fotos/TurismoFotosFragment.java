package com.app.turistae.ui.turismo_fotos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.turistae.R;
import com.app.turistae.databinding.FragmentTurismoFotosBinding;


public class TurismoFotosFragment extends Fragment {

    private FragmentTurismoFotosBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTurismoFotosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}