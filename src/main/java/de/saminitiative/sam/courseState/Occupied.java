package de.saminitiative.sam.courseState;

public class Occupied implements State {
    @Override
    public boolean updatePossible() {
        return false;
    }
}
