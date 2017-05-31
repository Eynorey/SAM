package de.saminitiative.sam.coursestate;

public class Occupied extends State {
    @Override
    public boolean updatePossible() {
        return false;
    }
}
