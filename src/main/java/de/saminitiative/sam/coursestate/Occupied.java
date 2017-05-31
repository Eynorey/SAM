package de.saminitiative.sam.coursestate;

public class Occupied implements State{

    @Override
    public boolean updatePossible() {
        return false;
    }
}
