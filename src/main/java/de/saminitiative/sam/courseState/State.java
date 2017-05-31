package de.saminitiative.sam.courseState;

import java.io.Serializable;

public abstract class State implements Serializable{
    public abstract boolean updatePossible();
}
