package com.nhlstenden.party;

import com.nhlstenden.exception.PositionAlreadyTakenException;

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

    /**
     * Add a representative to the party.
     * @param representative The representative to add.
     * @param position The position to add the representative at. If 0 is provided it will be put on the first
     *                 available spot.
     * @throws PositionAlreadyTakenException when the position is already taken.
     */
    public void addRepresentative(Representative representative, int position)
    {
        if (this.representatives.containsKey(position))
        {
            throw new PositionAlreadyTakenException();
        }

        if (position == 0)
        {
            this.representatives.put(firstAvailableSpot(), representative);
            return;
        }

        this.representatives.put(position, representative);
    }

    public Orientation getOrientation()
    {
        return this.orientation;
    }

    public void setOrientation(Orientation orientation)
    {
        this.orientation = orientation;
    }

    /**
     * Find a first available spot in our representatives list.
     * @return An index of the first available spot.
     */
    private int firstAvailableSpot()
    {
        int firstAvailableSpot = 2;

        while (this.representatives.containsValue(firstAvailableSpot))
        {
            firstAvailableSpot++;
        }

        return firstAvailableSpot;
    }
}
