package com.cruzurc.pmn836_lab4.model;

import android.content.Context;
import android.content.res.AssetManager;

import com.cruzurc.pmn836_lab4.MainActivity;
import com.cruzurc.pmn836_lab4.StarshipActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Fleet {
    private String name;
    private ArrayList<Starship> starships;

    public Fleet(String name, ArrayList<Starship> starships){
        this.name = name;
        this.starships = starships;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Starship> getStarships() {
        return starships;
    }

    public void setStarships(ArrayList<Starship> starships) {
        this.starships = starships;
    }

    public int getSizeOfFleet(){
        return starships.size();
    }

    public void addStarship(Starship starship){
        starships.add(starship);
    }



    public void loadStarships(String dirName, StarshipActivity activity) throws IOException {
        AssetManager manager = activity.getAssets();
        try {
            String[] fileList = manager.list(dirName);
            if (fileList != null) {
                for (String fileName : fileList) {
                    InputStream file = manager.open(dirName + "/" + fileName);
                    Starship newStarship;
                    String name = "";
                    String registry = "";
                    String starshipClass = "";
                    String line = "";
                    String[] words = new String[3];
                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        words = line.split(",");
                        name = words[0];
                        registry = words[1];
                        starshipClass = words[2];
                        newStarship = new Starship(name, registry, starshipClass, null);
                        newStarship.loadMembers(registry, activity);
                        starships.add(newStarship);
                    }
                }
            }

        } catch (FileNotFoundException except) {
            System.out.println("You fucked up");
        }
        catch(IOException except){
            System.out.print("No");
        }
    }

    @Override
    public String toString(){
        for (Starship starship:getStarships()){
            return starship.getName();
        }
        return "";
    }
}

