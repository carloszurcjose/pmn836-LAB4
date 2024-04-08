package com.cruzurc.pmn836_lab4.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.cruzurc.pmn836_lab4.MainActivity;
import com.cruzurc.pmn836_lab4.StarshipActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author pmn836
 * Represents a Starship, containing details such as its name, registry number, class,
 * and the crew members aboard.
 */

public class Starship {
    private String name;
    private String registry;
    private String classOfStarship;
    private ArrayList<CrewMember> members;

    /**
     * Constructs a new Starship with specified name, registry number, class, and crew members.
     *
     * @param name The name of the starship.
     * @param registry The registry number of the starship.
     * @param classOfStarship The class of the starship.
     * @param members The list of crew members on the starship.
     */

    public Starship(String name, String registry, String classOfStarship, ArrayList<CrewMember> members){
        this.name = name;
        this.registry = registry;
        this.classOfStarship = classOfStarship;
        this.members = new ArrayList<>();

    }

    /**
     * Constructs a Starship object from a Parcel. This constructor is used for Parcelable interface.
     *
     * @param in The Parcel containing the Starship data.
     */
    protected Starship(Parcel in) {
        name = in.readString();
        registry = in.readString();
        classOfStarship = in.readString();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getClassOfStarship() {
        return classOfStarship;
    }

    public void setClassOfStarship(String classOfStarship) {
        this.classOfStarship = classOfStarship;
    }

    public ArrayList<CrewMember> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<CrewMember> members) {
        this.members = members;
    }

    /**
     * Adds a crew member to the starship.
     *
     * @param member The crew member to add.
     */

    public void addCrewMember(CrewMember member){
        members.add(member);
    }

    /**
     * Gets the number of personnel on the starship.
     *
     * @return The number of crew members.
     */

    public int getNumberOfPersonnel(){
        return members.size();
    }

    /**
     * Loads crew members from a CSV file and adds them to this starship.
     * Only members with a matching registry will be added.
     *
     * @param Registry The registry to match against crew members in the file.
     * @param activity The context used to access assets.
     */

    public void loadMembers(String Registry, Context activity){
        //File file = new File("personnel/personnel.csv");
        AssetManager manager = activity.getAssets();

        try {
            InputStream file = manager.open("personnel/personnel.csv");
            Scanner scanner = new Scanner(file);
            CrewMember member;
            String name = "";
            String position = "";
            String title = "";
            String registry = "";
            String species = "";
            String line = "";
            String[] words = new String[5];
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                words = line.split(",");
                name = words[0];
                position = words[1];
                title = words[2];
                registry = words[3];
                species = words[4];
                if( registry.equals(Registry)) {
                    member = new CrewMember(name, position, title, registry, species, 0);
                    addCrewMember(member);
                }
            }
        }
        catch( FileNotFoundException exception){
            System.out.println("Your dumbass");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString(){
        return getName() + " " + getRegistry() + " " + getClassOfStarship() + " " + getMembers();
    }


}