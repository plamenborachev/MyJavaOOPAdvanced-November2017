package p05KingsGambitExtended.models;

import p05KingsGambitExtended.contracts.Attackable;
import p05KingsGambitExtended.contracts.KillableUnits;
import p05KingsGambitExtended.contracts.Observer;

public abstract class KingsUnit extends Unit implements Observer {

    private int health;

    /**
     * common constructor to set the common field
     *
     * @param name - unique name for the unit
     */
    KingsUnit(String name, int health) {
        super(name);
        this.health = health;
    }


    @Override
    public void takeHit() {
        this.health--;
    }

    @Override
    public int getHealth() {
        return this.health;
    }
}
