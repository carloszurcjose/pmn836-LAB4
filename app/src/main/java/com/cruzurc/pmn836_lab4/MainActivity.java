package com.cruzurc.pmn836_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.cruzurc.pmn836_lab4.databinding.ActivityMainBinding;
import com.cruzurc.pmn836_lab4.model.Fleet;
import com.cruzurc.pmn836_lab4.model.Starship;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author pmn836 Carlos Cruz
 * The main activity class that serves as the entry point of the application.
 * It handles the initialization of the application and the UI components.
 */

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    /**
     * Initializes the activity, setting up the layout and UI components.
     * It sets up listeners for buttons to navigate to the StarshipActivity with different values.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being
     *                           shut down, then this Bundle contains the data it most recently
     *                           supplied in onSaveInstanceState(Bundle). Otherwise, it is null.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Intent intent = new Intent(MainActivity.this, StarshipActivity.class);

        binding.buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("value", "A");
                startActivity(intent);


            }
        });
        binding.buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("value", "D");
                startActivity(intent);

            }
        });
        binding.buttonNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("value", "#");
                startActivity(intent);

            }
        });



    }
}