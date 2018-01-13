package panzer.controllers;

import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.core.PanzerBattleOperator;
import panzer.models.Parts.ArsenalPart;
import panzer.models.Parts.EndurancePart;
import panzer.models.Parts.ShellPart;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {

    private Map<String, Vehicle> vehicles;
    private Map<String, Vehicle> defeatedVehicles;

    public ManagerImpl() {
        this.vehicles = new LinkedHashMap<>();
        this.defeatedVehicles = new LinkedHashMap<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        String vehicleType = arguments.get(0);
        String model = arguments.get(1);
        double weight = Double.parseDouble(arguments.get(2));
        BigDecimal price = new BigDecimal(arguments.get(3));
        int attack = Integer.parseInt(arguments.get(4));
        int defense = Integer.parseInt(arguments.get(5));
        int hitPoints = Integer.parseInt(arguments.get(6));
        Vehicle vehicle = null;
        switch (vehicleType){
            case "Vanguard":
                vehicle = new Vanguard(model, weight, price, attack, defense, hitPoints);
                break;
            case "Revenger":
                vehicle = new Revenger(model, weight, price, attack, defense, hitPoints);
                break;
        }
        this.vehicles.putIfAbsent(model, vehicle);

        return String.format("Created %s Vehicle - %s", vehicleType, model);
    }

    @Override
    public String addPart(List<String> arguments) {

        String vehicleModel = arguments.get(0);
        String partType = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        int additionalParameter = Integer.parseInt(arguments.get(5));
        Part part = null;
        switch (partType){
            case "Arsenal":
                part = new ArsenalPart(model, weight, price, additionalParameter);
                this.vehicles.get(vehicleModel).addArsenalPart(part);
                break;
            case "Shell":
                part = new ShellPart(model, weight, price, additionalParameter);
                this.vehicles.get(vehicleModel).addShellPart(part);
                break;
            case "Endurance":
                part = new EndurancePart(model, weight, price, additionalParameter);
                this.vehicles.get(vehicleModel).addEndurancePart(part);
                break;
        }
        return String.format("Added %s - %s to Vehicle - %s", partType, model, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) throws NoSuchFieldException, IllegalAccessException {
        String model = arguments.get(0);
        StringBuilder sb = new StringBuilder();
        if(this.vehicles.containsKey(model)){
            Vehicle currentVehicle = this.vehicles.get(model);
            sb.append(String.format("%s - %s", currentVehicle.getClass().getSimpleName(), currentVehicle.getModel())).append(System.lineSeparator());
            sb.append(String.format("Total Weight: %.3f", currentVehicle.getTotalWeight())).append(System.lineSeparator());
            sb.append(String.format("Total Price: %.3f", currentVehicle.getTotalPrice())).append(System.lineSeparator());
            sb.append(String.format("Attack: %d", currentVehicle.getTotalAttack())).append(System.lineSeparator());
            sb.append(String.format("Defense: %d", currentVehicle.getTotalDefense())).append(System.lineSeparator());
            sb.append(String.format("HitPoints: %d", currentVehicle.getTotalHitPoints())).append(System.lineSeparator());
            List<Part> parts = (List<Part>) this.vehicles.get(model).getParts();
            if (parts.size() == 0){
                sb.append("Parts: None");
            } else {
                List<String> partNames = parts.stream().map(Part::getModel).collect(Collectors.toList());
                sb.append(String.format("Parts: %s", partNames.toString().replaceAll("[\\[\\]]", ""))).append(System.lineSeparator());
            }
        } else {
            Part part = null;
            for (Vehicle vehicle : this.vehicles.values()) {
                for (Part item : vehicle.getParts()) {
                    if (item.getModel().equals(model)){
                        part = item;
                        break;
                    }
                }
            }
            if (part != null){
                sb.append(part.toString());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String battle(List<String> arguments) {
        String vehicle1Model = arguments.get(0);
        String vehicle2Model = arguments.get(1);
        BattleOperator battleOperator = new PanzerBattleOperator();
        Vehicle attacker = this.vehicles.get(vehicle1Model);
        Vehicle target = this.vehicles.get(vehicle2Model);
        String winner = battleOperator.battle(attacker, target);
        if (vehicle1Model.equals(winner)){
            this.vehicles.remove(vehicle2Model);
            this.defeatedVehicles.putIfAbsent(vehicle2Model, target);
        } else {
            this.vehicles.remove(vehicle1Model);
            this.defeatedVehicles.putIfAbsent(vehicle1Model, attacker);
        }
        return String.format("%s versus %s -> %s Wins! Flawless Victory!", vehicle1Model, vehicle2Model, winner);
    }

    @Override
    public String terminate(List<String> arguments) throws NoSuchFieldException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        if (this.vehicles.size() == 0){
            sb.append("Remaining Vehicles: None").append(System.lineSeparator());
        } else {
            List<String> remainingVehicles = this.vehicles.keySet().stream().collect(Collectors.toList());
            sb.append(String.format("Remaining Vehicles: %s", remainingVehicles.toString().replaceAll("[\\[\\]]", ""))).append(System.lineSeparator());
        }
        if (this.defeatedVehicles.size() == 0){
            sb.append("Defeated Vehicles: None").append(System.lineSeparator());
        } else {
            List<String> defeatedVehicles = this.defeatedVehicles.keySet().stream().collect(Collectors.toList());
            sb.append(String.format("Defeated Vehicles: %s", defeatedVehicles.toString().replaceAll("[\\[\\]]", ""))).append(System.lineSeparator());
        }
        int currentlyUsedParts = 0;
        for (Vehicle vehicle : this.vehicles.values()) {
            for (Iterator<Part> it = vehicle.getParts().iterator(); it.hasNext(); ) {
                Part part = it.next();
                currentlyUsedParts++;

            }
        }
        if (currentlyUsedParts == 0){
            sb.append("Currently Used Parts: None");
        } else {
            sb.append(String.format("Currently Used Parts: %d", currentlyUsedParts));
        }
        return sb.toString();
    }
}
