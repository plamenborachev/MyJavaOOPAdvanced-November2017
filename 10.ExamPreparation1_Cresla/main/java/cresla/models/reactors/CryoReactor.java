package cresla.models.reactors;

import cresla.interfaces.Container;

public class CryoReactor extends AbstractReactor {

    private int cryoProductionIndex;

    public CryoReactor(int id, Container container, int cryoProductionIndex) {
        super(id, container);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
        if (result > this.getTotalHeatAbsorbing()){
            result = 0;
        }
        return result;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing();
    }

    @Override
    public String toString() {
        try {
            return "CryoReactor - " + super.getId() + System.lineSeparator() +
                    "Energy Output: " + this.getTotalEnergyOutput() + System.lineSeparator() +
                    "Heat Absorbing: " + this.getTotalHeatAbsorbing()+ System.lineSeparator() +
                    "Modules: " + super.getModuleCount();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
