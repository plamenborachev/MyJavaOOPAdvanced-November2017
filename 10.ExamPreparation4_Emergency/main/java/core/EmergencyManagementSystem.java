package core;

import collection.EmergencyRegister;
import collection.Register;
import models.centers.EmergencyCenter;
import models.emergencies.Emergency;

import java.util.*;

public class EmergencyManagementSystem implements ManagementSystem {
    private static final String PROPERTY = "Property";
    private static final String HEALTH = "Health";
    private static final String ORDER = "Order";
    private static final String FIRE = "Fire";
    private static final String POLICE = "Police";
    private static final String MEDICAL = "Medical";
    private static final String REGISTERED_PUBLIC_S_EMERGENCY_OF_LEVEL_S_AT_S = "Registered Public %s Emergency of level %s at %s.";
    private static final String REGISTERED_S_SERVICE_EMERGENCY_CENTER_S = "Registered %s Service Emergency Center - %s.";
    private static final String SUCCESSFULLY_RESPONDED_TO_ALL_S_EMERGENCIES = "Successfully responded to all %s emergencies.";
    private static final String S_EMERGENCIES_LEFT_TO_PROCESS_AMOUNT_OF_EMERGENCIES_LEFT = "%s Emergencies left to process: %d.";

    private Map<String, Register<EmergencyCenter>> centers;
    private Map<String, Register<Emergency>> emergencies;
    private Map<String, Long> statistics;
    private int totalProcessedEmergencies;

    public EmergencyManagementSystem() {
        this.totalProcessedEmergencies = 0;
        this.initializeCenters();
        this.initializeStatistics();
        this.initializeEmergencies();
    }

    private void initializeStatistics() {
        this.statistics = new LinkedHashMap<>();
        this.statistics.put(PROPERTY, 0L);
        this.statistics.put(HEALTH, 0L);
        this.statistics.put(ORDER, 0L);
    }

    private void initializeEmergencies() {
        this.emergencies = new LinkedHashMap<>();
        this.emergencies.put(PROPERTY, new EmergencyRegister<>());
        this.emergencies.put(HEALTH, new EmergencyRegister<>());
        this.emergencies.put(ORDER, new EmergencyRegister<>());
    }

    private void initializeCenters() {
        this.centers = new LinkedHashMap<>();
        this.centers.put(PROPERTY, new EmergencyRegister<>());
        this.centers.put(HEALTH, new EmergencyRegister<>());
        this.centers.put(ORDER, new EmergencyRegister<>());
    }

    @Override
    public String registerPropertyEmergency(Emergency emergency) {
        this.emergencies.get(PROPERTY).enqueueEmergency(emergency);
        return String.format(REGISTERED_PUBLIC_S_EMERGENCY_OF_LEVEL_S_AT_S,
                PROPERTY, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerHealthEmergency(Emergency emergency) {
        this.emergencies.get(HEALTH).enqueueEmergency(emergency);
        return String.format(REGISTERED_PUBLIC_S_EMERGENCY_OF_LEVEL_S_AT_S,
                HEALTH, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerOrderEmergency(Emergency emergency) {
        this.emergencies.get(ORDER).enqueueEmergency(emergency);
        return String.format(REGISTERED_PUBLIC_S_EMERGENCY_OF_LEVEL_S_AT_S,
                ORDER, emergency.getEmergencyLevel(), emergency.getRegistrationTime());
    }

    @Override
    public String registerFireServiceCenter(EmergencyCenter center) {
        this.centers.get(PROPERTY).enqueueEmergency(center);
        return String.format(REGISTERED_S_SERVICE_EMERGENCY_CENTER_S, FIRE, center.getName());
    }

    @Override
    public String registerMedicalServiceCenter(EmergencyCenter center) {
        this.centers.get(HEALTH).enqueueEmergency(center);
        return String.format(REGISTERED_S_SERVICE_EMERGENCY_CENTER_S, MEDICAL, center.getName());
    }

    @Override
    public String registerPoliceServiceCenter(EmergencyCenter center) {
        this.centers.get(ORDER).enqueueEmergency(center);
        return String.format(REGISTERED_S_SERVICE_EMERGENCY_CENTER_S, POLICE, center.getName());
    }

    @Override
    public String processEmergencies(String type) {
        Register<EmergencyCenter> centerRegister = this.centers.get(type);
        Register<Emergency> emergencyRegister = this.emergencies.get(type);

        while (!emergencyRegister.isEmpty()) {
            if (centerRegister.isEmpty()) {
                return String.format(S_EMERGENCIES_LEFT_TO_PROCESS_AMOUNT_OF_EMERGENCIES_LEFT, type, emergencyRegister.size());
            }

            EmergencyCenter center = centerRegister.dequeueEmergency();

            if (!center.isForRetirement()) {
                Emergency emergency = emergencyRegister.dequeueEmergency();
                center.processEmergency();
                centerRegister.enqueueEmergency(center);

                this.statistics.put(type, this.statistics.get(type) + emergency.getAdditionalParam());
                this.totalProcessedEmergencies++;
            }
        }

        return String.format(SUCCESSFULLY_RESPONDED_TO_ALL_S_EMERGENCIES, type);
    }

    @Override
    public String emergencyReport() {
        for (Register<EmergencyCenter> centerRegister : this.centers.values()) {
            List<EmergencyCenter> temp = new LinkedList<>();
            while (!centerRegister.isEmpty()) {
                EmergencyCenter currentCenter = centerRegister.dequeueEmergency();
                if (currentCenter.isForRetirement()) {
                    continue;
                }
                temp.add(currentCenter);
            }
            for (EmergencyCenter emergencyCenter : temp) {
                centerRegister.enqueueEmergency(emergencyCenter);
            }
        }

        Integer allRegisteredEmergencies = this.emergencies.entrySet().stream().
                mapToInt(currentEmergencies -> currentEmergencies.getValue().size()).sum();

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("PRRM Services Live Statistics%n"));
        builder.append(String.format("Fire Service Centers: %d%n", this.centers.get(PROPERTY).size()));
        builder.append(String.format("Medical Service Centers: %d%n", this.centers.get(HEALTH).size()));
        builder.append(String.format("Police Service Centers: %d%n", this.centers.get(ORDER).size()));
        builder.append(String.format("Total Processed Emergencies: %d%n", this.totalProcessedEmergencies));
        builder.append(String.format("Currently Registered Emergencies: %d%n", allRegisteredEmergencies));
        builder.append(String.format("Total Property Damage Fixed: %d%n", this.statistics.get(PROPERTY)));
        builder.append(String.format("Total Health Casualties Saved: %d%n", this.statistics.get(HEALTH)));
        builder.append(String.format("Total Special Cases Processed: %d", this.statistics.get(ORDER)));
        return builder.toString();
    }
}
