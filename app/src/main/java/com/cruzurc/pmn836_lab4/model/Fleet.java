package com.cruzurc.pmn836_lab4.model;

import java.util.ArrayList;

public class Fleet {
    private String name;
    private ArrayList<Starship> starships = new ArrayList<>();

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

    public void loadStarships(String dirName){

    }
    @Override
    public String toString(){
        for (Starship starship:getStarships()){
            return starship.getName();
        }
        return "";
    }
}
