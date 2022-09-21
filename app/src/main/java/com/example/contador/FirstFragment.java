package com.example.contador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.contador.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    int lp1 = 0;
    int lp2 = 0;
    int pp1 = 0;
    int pp2 = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        reset();

        if (savedInstanceState!=null) {
            lp1 = savedInstanceState.getInt("lp1");
            lp2 = savedInstanceState.getInt("lp2");
            pp1 = savedInstanceState.getInt("pp1");
            pp2 = savedInstanceState.getInt("pp2");
        }

        updateCounters();

        return binding.getRoot();
    }

    private void updateCounters() {
        binding.txtCounterP1.setText(lp1 + "/" + pp1);
        binding.txtCounterP2.setText(lp2 + "/" + pp2);
    }

    private void reset() {
        lp1 = 0;
        lp2 = 0;
        pp1 = 0;
        pp2 = 0;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnLpP1.setOnClickListener(btn -> {
            lp1++;
            updateCounters();
        });

        binding.btnLlP1.setOnClickListener(btn -> {
            lp1--;
            updateCounters();
        });

        binding.btnPp1.setOnClickListener(btn -> {
            pp1++;
            updateCounters();
        });
        binding.btnPlP1.setOnClickListener(btn -> {
            pp1--;
            updateCounters();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lp1", lp1);
        outState.putInt("lp2", lp2);
        outState.putInt("pp1", pp1);
        outState.putInt("pp2", pp2);
    }
}