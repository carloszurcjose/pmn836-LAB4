package com.cruzurc.pmn836_lab4.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Starship {
    private String name;
    private String registry;
    private String classOfStarship;
    private ArrayList<CrewMember> members;

    public Starship(String name, String registry, String classOfStarship, ArrayList<CrewMember> members){
        this.name = name;
        this.registry = registry;
        this.classOfStarship = classOfStarship;
        this.members = new ArrayList<>();

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

    public void addCrewMember(CrewMember member){
        members.add(member);
    }

    public int getNumberOfPersonnel(){
        return members.size();
    }

    public void loadMembers(String Registry){
        File file = new File("personnel/personnel.csv");
        try {
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
                    member = new CrewMember(name, position, title, registry, species);
                    addCrewMember(member);
                }
            }
        }
        catch( FileNotFoundException exception){
            System.out.println("Your dumbass");
        }
    }
    @Override
    public String toString(){
        return getName() + " " + getRegistry() + " " + getClassOfStarship() + " " + getMembers();
    }
}