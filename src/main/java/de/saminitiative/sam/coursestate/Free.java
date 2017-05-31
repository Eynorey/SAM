package de.saminitiative.sam.coursestate;

public class Free implements State{

    @Override
    public boolean updatePossible() {
        return true;
    }
}
