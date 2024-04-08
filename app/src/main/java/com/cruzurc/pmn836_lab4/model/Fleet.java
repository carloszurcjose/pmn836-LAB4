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

/**
 * @author pmn836 Carlos Cruz
 * Represents a fleet, a collection of starships under a single name or command.
 */

public class Fleet {
    private String name;
    private ArrayList<Starship> starships;

    /**
     * Constructs a Fleet with a specified name and a list of starships.
     *
     * @param name The name of the fleet.
     * @param starships The list of starships in the fleet.
     */


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

    /**
     * Gets the size of the fleet, i.e., the number of starships in the fleet.
     *
     * @return The size of the fleet.
     */

    public int getSizeOfFleet(){
        return starships.size();
    }

    /**
     * Adds a starship to the fleet.
     *
     * @param starship The starship to add to the fleet.
     */

    public void addStarship(Starship starship){
        starships.add(starship);
    }

    /**
     * Loads starships from assets based on a directory name and the current application context.
     * This method scans through the specified directory, loading each starship's details and
     * populating the fleet.
     *
     * @param dirName The name of the directory in the assets folder to scan for starship details.
     * @param activity The current application context.
     * @throws IOException If there is an error reading from the assets.
     */



    public void loadStarships(String dirName, Context activity) throws IOException {
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

