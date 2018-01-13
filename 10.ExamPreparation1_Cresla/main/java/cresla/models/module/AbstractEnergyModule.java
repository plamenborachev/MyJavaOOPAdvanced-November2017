package cresla.models.module;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyModule extends AbstractModule implements EnergyModule {

    private int energyOutput;

    protected AbstractEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Module - " + super.getId() + System.lineSeparator() +
                "Energy Output: " + this.energyOutput;
    }
}
