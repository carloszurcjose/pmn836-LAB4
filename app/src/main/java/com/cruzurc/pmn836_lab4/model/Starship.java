package com.cruzurc.pmn836_lab4.model;

import java.util.ArrayList;

public class Starship {
    private String name;
    private String registry;
    private String classOfStarship;
    private ArrayList<CrewMember> members = new ArrayList<>();

    public Starship(String name, String registry, String classOfStarship, ArrayList<CrewMember> members){
        this.name = name;
        this.registry = registry;
        this.classOfStarship = classOfStarship;
        this.members = members;

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
    @Override
    public String toString(){
        return getName() + " " + getRegistry() + " " + getClassOfStarship() + " " + getMembers();
    }
}