package de.saminitiative.sam.courseState;

public class Free implements State {
    @Override
    public boolean updatePossible() {
        return true;
    }
}
