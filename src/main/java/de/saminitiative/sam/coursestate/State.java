package de.saminitiative.sam.coursestate;

import java.io.Serializable;

public abstract class State implements Serializable{
    public abstract boolean updatePossible();
}
