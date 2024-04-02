package com.cruzurc.pmn836_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cruzurc.pmn836_lab4.databinding.ActivityMainBinding;
import com.cruzurc.pmn836_lab4.model.Fleet;
import com.cruzurc.pmn836_lab4.model.Starship;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //ArrayList<Starship> starships = new ArrayList<>();
       // Fleet fleet = new Fleet("Carlos's Fleet", starships );
        //try {
         //   fleet.loadStarships("fleets", this);
         //   Log.d("inputers", "ItWorked");
        //} catch (IOException e) {
        //    Log.d("inputers","No");
        //    throw new RuntimeException(e);


        Intent intent = new Intent(MainActivity.this, StarshipActivity.class);

        binding.buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("value", String.valueOf("buttonA"));
                startActivity(intent);


            }
        });
        binding.buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("value", String.valueOf("buttonD"));
                startActivity(intent);

            }
        });
        binding.buttonNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("value", String.valueOf("buttonNumbers"));
                startActivity(intent);

            }
        });
    }
}