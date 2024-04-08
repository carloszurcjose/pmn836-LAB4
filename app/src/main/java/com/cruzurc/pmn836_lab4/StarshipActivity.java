package com.cruzurc.pmn836_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.cruzurc.pmn836_lab4.databinding.ActivityStarshipBinding;
import com.cruzurc.pmn836_lab4.model.CrewMember;
import com.cruzurc.pmn836_lab4.model.Fleet;
import com.cruzurc.pmn836_lab4.model.Starship;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author pmn836 Carlos Cruz
 * Activity class representing the starship details and its crew members.
 * It initializes the UI components and sets up data based on the selected starship.
 */

public class StarshipActivity extends AppCompatActivity {

    private ActivityStarshipBinding binding;

    /**
     * Initializes the activity, setting up the layout and populating the view components
     * with the data of the selected starship and its crew members.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). Otherwise, it is null.
     */

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
            Log.d("inputers", "You done messed up");
            throw new RuntimeException(e);
        }

        //Log.i("starship", fleet.getStarships().get(1).getName());
        ArrayList<CrewMember> membersA = new ArrayList<>();
        ArrayList<CrewMember> membersD = new ArrayList<>();
        ArrayList<CrewMember> membersNumbers = new ArrayList<>();
        int i = 0;
        for( Starship starship: fleet.getStarships()) {
            for (CrewMember newMembers : starship.getMembers()) {
                //Log.i("inputers", members.toString());
                if (i == 3) {
                    membersA.add(new CrewMember(newMembers.getName(), newMembers.getPosition(), newMembers.getRank(), newMembers.getSpecies(), newMembers.getAssignment(), newMembers.getId()));
                } else if (i == 4) {
                    membersD.add(new CrewMember(newMembers.getName(), newMembers.getPosition(), newMembers.getRank(), newMembers.getSpecies(), newMembers.getAssignment(), newMembers.getId()));

                } else if (i == 8) {
                    membersNumbers.add(new CrewMember(newMembers.getName(), newMembers.getPosition(), newMembers.getRank(), newMembers.getSpecies(), newMembers.getAssignment(), newMembers.getId()));

                }
            }
            ++i;

        }


        String starshipp = getIntent().getStringExtra("value");

        TextView textView = findViewById(R.id.text_view_registry_name);

        RecyclerView recycleView = findViewById(R.id.recycler_view);


        if( starshipp.equals("A")){
            textView.setText("USS Enterprise\nNCC-1701-A");
            StarshipActivityAdapter adapterA = new StarshipActivityAdapter(this, membersA);
            recycleView.setAdapter(adapterA);

        }

        else if(starshipp.equals("D")){
            textView.setText("USS Enterprise\nNCC-1701-D");
            StarshipActivityAdapter adapterB = new StarshipActivityAdapter(this, membersD);
            recycleView.setAdapter(adapterB);

        }

        else if(starshipp.equals("#")){
            textView.setText("USS Voyager\nNCC-74656");
            StarshipActivityAdapter adapterNumbers = new StarshipActivityAdapter(this, membersNumbers);
            recycleView.setAdapter(adapterNumbers);

        }

        recycleView.setLayoutManager(new LinearLayoutManager((this)));

        //Find the parent LinearLayout
    }
}


