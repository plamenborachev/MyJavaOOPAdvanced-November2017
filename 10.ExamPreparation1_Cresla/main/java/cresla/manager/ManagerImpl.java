package cresla.manager;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;
import cresla.models.module.CooldownSystem;
import cresla.models.module.CryogenRod;
import cresla.models.module.HeatProcessor;
import cresla.models.reactors.CryoReactor;
import cresla.models.reactors.HeatReactor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private int id;
    private Map<Integer, Reactor> reactorMap;
    private Map<Integer, Module> moduleMap;
    private int energyModulesCounter;
    private int absorbingModulesCounter;
    private int cryoReactorCounter;
    private int heatReactorCounter;


    public ManagerImpl() {
        this.id = 1;
        this.reactorMap = new HashMap<>();
        this.moduleMap = new HashMap<>();
        this.energyModulesCounter = 0;
        this.absorbingModulesCounter = 0;
        this.cryoReactorCounter = 0;
        this.heatReactorCounter = 0;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Container container = new ModuleContainer(Integer.parseInt(arguments.get(3)));
        if ("Cryo".equals(arguments.get(1))) {
            this.reactorMap.putIfAbsent(this.id, new CryoReactor(this.id, container, Integer.parseInt(arguments.get
                    (2))));
            this.cryoReactorCounter++;
        } else {
            this.reactorMap.putIfAbsent(this.id, new HeatReactor(this.id, container, Integer.parseInt(arguments.get
                    (2))));
            this.heatReactorCounter++;
        }
        return "Created " + arguments.get(1) + " Reactor - " + this.id++;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(1));
        switch (arguments.get(2)) {
            case "CryogenRod":
                EnergyModule module = new CryogenRod(this.id, Integer.parseInt(arguments.get(3)));
                this.reactorMap.get(reactorId).addEnergyModule(module);
                this.moduleMap.putIfAbsent(this.id, module);
                this.energyModulesCounter++;
                break;
            case "HeatProcessor":
                AbsorbingModule module1 = new HeatProcessor(this.id, Integer.parseInt(arguments.get(3)));
                this.reactorMap.get(reactorId).addAbsorbingModule(module1);
                this.moduleMap.putIfAbsent(this.id, module1);
                this.absorbingModulesCounter++;
                break;
            case "CooldownSystem":
                AbsorbingModule module2 = new CooldownSystem(this.id, Integer.parseInt(arguments.get(3)));
                this.reactorMap.get(reactorId).addAbsorbingModule(module2);
                this.moduleMap.putIfAbsent(this.id, module2);
                this.absorbingModulesCounter++;
                break;
            default:
                break;
        }
        return String.format("Added %s - %d to Reactor - %d",
                arguments.get(2), this.id++, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int targetId = Integer.parseInt(arguments.get(1));
        if (this.reactorMap.containsKey(targetId)){
            return this.reactorMap.get(targetId).toString();
        } else {
            return this.moduleMap.get(targetId).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long totalEnergyOutput = this.reactorMap.entrySet().stream()
                .mapToLong(r -> r.getValue().getTotalEnergyOutput()).sum();
        long totalHeatAbsorbing = this.reactorMap.entrySet().stream()
                .mapToLong(r -> r.getValue().getTotalHeatAbsorbing()).sum();
        return "Cryo Reactors: " + this.cryoReactorCounter + System.lineSeparator() +
                "Heat Reactors: " + this.heatReactorCounter + System.lineSeparator() +
                "Energy Modules: " + this.energyModulesCounter + System.lineSeparator() +
                "Absorbing Modules: " + this.absorbingModulesCounter + System.lineSeparator() +
                "Total Energy Output: " + totalEnergyOutput + System.lineSeparator() +
                "Total Heat Absorbing: " + totalHeatAbsorbing;
    }
}
