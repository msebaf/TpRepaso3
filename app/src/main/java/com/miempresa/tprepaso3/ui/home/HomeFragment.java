package com.miempresa.tprepaso3.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.miempresa.tprepaso3.MenuActivity;
import com.miempresa.tprepaso3.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;
private HomeViewModel mv ;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        Context context = requireContext();

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        mv = new ViewModelProvider(HomeFragment.this).get(HomeViewModel.class);
        mv.getResultado().observe(getViewLifecycleOwner() , new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvResultado.setText(s.toString());
            }
        });


        binding.btLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mv.llamar(getContext() , binding.ptNumero.getText().toString());
            }
        });


        return root;
    }



@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}