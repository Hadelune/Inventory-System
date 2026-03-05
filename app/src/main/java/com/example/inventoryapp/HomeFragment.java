package com.example.inventoryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.inventoryapp.databinding.ActivityMainBinding;

//A.I GENERATED NEED TO LEARN HOW THE FRAGMENTS WORKS AS OF NOW
public class HomeFragment extends Fragment {
    private ActivityMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        binding = ActivityMainBinding.inflate(inflater, container, false);
        return  binding.getRoot();
    }
}
