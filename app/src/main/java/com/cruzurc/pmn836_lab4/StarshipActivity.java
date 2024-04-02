package com.cruzurc.pmn836_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cruzurc.pmn836_lab4.databinding.ActivityStarshipBinding;
import com.cruzurc.pmn836_lab4.model.Fleet;
import com.cruzurc.pmn836_lab4.model.Starship;

import java.io.IOException;
import java.util.ArrayList;

public class StarshipActivity extends AppCompatActivity {

    private ActivityStarshipBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStarshipBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ArrayList<Starship> starships = new ArrayList<>();
        Fleet fleet = new Fleet("Carlos's Fleet", starships);
        try{
            fleet.loadStarships("fleets", this);
            Log.d("inputers", "ItWorked");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setContentView(view);

        String answer = getIntent().getStringExtra("value");

        binding.buttonMakeItChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.textViewToBeChanged.setText(getIntent().getStringExtra("value"));
            }
        });

    }
}