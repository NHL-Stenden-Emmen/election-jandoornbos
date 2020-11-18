package com.nhlstenden.party;

import java.util.HashMap;

public class Party
{
    private String name;
    private HashMap<Integer, Representative> representatives;
    private Orientation orientation;

    public Party(String name, Orientation orientation)
    {
        this.name = name;
        this.orientation = orientation;
        this.representatives = new HashMap<>();
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public HashMap<Integer, Representative> getRepresentatives()
    {
        return this.representatives;
    }

    public void addRepresentative(Representative representative, int position)
    {
        // TODO: Fill this method
        // TODO: When 0 is provided for position find the first available spot
        // TODO: Create Unit Tests
    }

    public Orientation getOrientation()
    {
        return this.orientation;
    }

    public void setOrientation(Orientation orientation)
    {
        this.orientation = orientation;
    }
}
