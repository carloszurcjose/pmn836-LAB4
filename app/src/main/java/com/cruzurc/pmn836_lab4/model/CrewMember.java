package com.cruzurc.pmn836_lab4.model;

import com.cruzurc.pmn836_lab4.R;
/**
 * @author pmn836 Carlos Cruz
 * Represents a crew member of a starship, detailing their name, position, rank, species, and assignment.
 */

public class CrewMember {
    private String name;
    private String position;
    private String rank;
    private String species;
    private String assignment;

    private int id;

    /**
     * Constructs a CrewMember with detailed information.
     *
     * @param name The name of the crew member.
     * @param position The position or job title of the crew member.
     * @param rank The rank of the crew member within the starship.
     * @param species The species of the crew member.
     * @param assignment The specific assignment or department of the crew member.
     * @param id A unique identifier for the crew member.
     */

    public CrewMember(String name, String position, String rank, String species, String assignment, int id ){
        this.name = name;
        this.position = position;
        this.rank = rank;
        this.species = species;
        this.assignment = assignment;
        this.id = id;
    }

    /**
     * Constructs a CrewMember without an ID.
     *
     * @param name The name of the crew member.
     * @param position The position or job title of the crew member.
     * @param rank The rank of the crew member within the starship.
     * @param species The species of the crew member.
     */

    public CrewMember(String name, String position, String rank, String species){
        this.name = name;
        this.position = position;
        this.rank = rank;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    /**
     * Gets the unique identifier for the crew member.
     * This method maps the crew member's name to a specific drawable resource ID.
     *
     * @return The drawable resource ID associated with the crew member.
     */

    public int getId() {
        String name = getName();
        int id = 0;
        if( name.equals("James T. Kirk")) {
            id = R.drawable.james_t__kirk;
        }
        else if( name.equals("Spock")) {
            id = R.drawable.spock;
        }
        else if( name.equals("Leonard McCoy")) {
            id = R.drawable.leonard_mccoy;
        }
        else if( name.equals("Montgomery Scott")) {
            id = R.drawable.montgomery_scott;
        }
        else if( name.equals("Jean-Luc Picard")) {
            id = R.drawable.jean_luc_picard;
        }
        else if( name.equals("William T. Riker")) {
            id = R.drawable.william_t__riker;
        }
        else if( name.equals("Beverly Crusher")) {
            id = R.drawable.beverly_crusher;
        }
        else if( name.equals("Geordi La Forge")) {
            id = R.drawable.geordi_la_forge;
        }
        else if( name.equals("Deanna Troi")) {
            id = R.drawable.deanna_troi;
        }
        else if( name.equals("Worf")) {
            id = R.drawable.worf;
        }
        else if( name.equals("Data")) {
            id = R.drawable.data;
        }
        else if( name.equals("Tasha Yar")) {
            id = R.drawable.tasha_yar;
        }
        else if( name.equals("Christine Chapel")) {
            id = R.drawable.christine_chapel;
        }
        else if( name.equals("B'Elanna Torres")) {
            id = R.drawable.b_elanna_torres;
        }
        else if( name.equals("Tom Paris")) {
            id = R.drawable.tom_paris;
        }
        else if( name.equals("The Doctor")) {
            id = R.drawable.the_doctor;
        }
        else if( name.equals("Nyota Uhura")) {
            id = R.drawable.nyota_uhura;
        }
        else if( name.equals("Neelix")) {
            id = R.drawable.neelix;
        }
        else if( name.equals("Hikaru Sulu")) {
            id = R.drawable.hikaru_sulu;
        }
        else if( name.equals("Kes")) {
            id = R.drawable.kes;
        }
        else if( name.equals("Pavel Chekov")) {
            id = R.drawable.pavel_chekov;
        }
        else if( name.equals("Kathryn Janeway")) {
            id = R.drawable.kathryn_janeway;
        }
        else if( name.equals("Chakotay")) {
            id = R.drawable.chakotay;
        }
        else if( name.equals("Tuvok")) {
            id = R.drawable.tuvok;
        }
        else{
            id = R.drawable.spock;

            }

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getName() + " " + getRank() + " " + getSpecies() + " " + getAssignment();
    }
}

