package cresla.models.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;

import java.lang.reflect.Field;
import java.util.LinkedList;

public abstract class AbstractReactor implements Reactor {

    private int id;
    private Container container;

    protected AbstractReactor(int id, Container container) {
        this.id = id;
        this.container = container;
    }

    protected Container getContainer() {
        return this.container;
    }

    @Override
    public abstract long getTotalEnergyOutput();

    @Override
    public abstract long getTotalHeatAbsorbing();

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int getModuleCount() throws NoSuchFieldException, IllegalAccessException {
        Class aClass = ModuleContainer.class;
        Field field = aClass.getDeclaredField("modulesByInput");
        field.setAccessible(true);
        return ((LinkedList<Module>)field.get(this.container)).size();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }


}
