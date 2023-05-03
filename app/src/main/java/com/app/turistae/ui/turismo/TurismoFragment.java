package com.app.turistae.ui.turismo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.turistae.databinding.FragmentTurismoBinding;


public class TurismoFragment extends Fragment {

    private FragmentTurismoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      binding = FragmentTurismoBinding.inflate(inflater, container, false);
      View root = binding.getRoot();
      return root;
    }
}