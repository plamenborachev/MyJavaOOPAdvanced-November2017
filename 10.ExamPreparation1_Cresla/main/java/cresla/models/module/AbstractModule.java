package cresla.models.module;

import cresla.interfaces.Module;

public abstract class AbstractModule implements Module {

    private int id;

    protected AbstractModule(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
