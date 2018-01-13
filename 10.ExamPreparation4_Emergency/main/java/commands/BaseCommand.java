package commands;


import core.ManagementSystem;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public abstract class BaseCommand implements Executable {

    private ManagementSystem system;

    protected BaseCommand(ManagementSystem system) {
        this.system = system;
    }

    protected ManagementSystem getManagementSystem() {
        return system;
    }
}
