package models;

import contracts.BoatRace;
import exceptions.DuplicateModelException;
import models.boats.BaseBoat;
import utility.Constants;
import utility.Validator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DefaultBoatRace implements BoatRace {

    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private Map<String, BaseBoat> registeredBoats;

    public DefaultBoatRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.allowsMotorBoats = allowsMotorBoats;
        this.registeredBoats = new LinkedHashMap<>();
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    private void setDistance(int distance) {
        Validator.validatePropertyPositiveValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return this.windSpeed;
    }

    @Override
    public int getOceanCurrentSpeed() {
        return this.oceanCurrentSpeed;
    }

    @Override
    public Boolean allowsMotorboats() {
        return this.allowsMotorBoats;
    }

    @Override
    public void addParticipant(BaseBoat boat) throws DuplicateModelException {
        if (this.registeredBoats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    @Override
    public List<BaseBoat> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }
}
