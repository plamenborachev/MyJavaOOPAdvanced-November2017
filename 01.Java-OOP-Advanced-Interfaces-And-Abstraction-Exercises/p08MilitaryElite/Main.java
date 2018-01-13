package p08MilitaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        Map<Integer, Soldier> soldiers = new LinkedHashMap<>();

        while (!"End".equals(input[0])) {
            Soldier soldier = null;
            Integer id = Integer.parseInt(input[1]);
            String firtsName = input[2];
            String lastName = input[3];
            switch (input[0]) {
                case "Private":
                    Double salary = Double.parseDouble(input[4]);
                    soldier = new PrivateImpl(id, firtsName, lastName, salary);
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(input[4]);
                    List<Soldier> privates = new ArrayList<>();
                    if (input.length > 5){
                        for (int i = 5; i < input.length; i++) {
                            Integer privateId = Integer.parseInt(input[i]);
                            privates.add(soldiers.get(privateId));
                        }
                    }
                    soldier = new LeutenantGeneralImpl(id, firtsName, lastName, salary, privates);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(input[4]);
                    String corps = input[5];
                    List<Repair> repairs = new ArrayList<>();
                    if (input.length > 6) {
                        for (int i = 6; i < input.length; i += 2) {
                            String repairPart = input[i];
                            Integer repairHour = Integer.parseInt(input[i + 1]);
                            Repair repair = new Repair(repairPart, repairHour);
                            repairs.add(repair);
                        }
                    }
                    try {
                        soldier = new EngineerImpl(id, firtsName, lastName, salary, corps, repairs);
                    } catch (IllegalArgumentException iae) {
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(input[4]);
                    corps = input[5];
                    List<Mission> missions = new ArrayList<>();
                    if (input.length > 6) {
                        for (int i = 6; i < input.length; i += 2) {
                            String missionCodeName = input[i];
                            String missionState = input[i + 1];
                            try {
                                Mission mission = new Mission(missionCodeName, missionState);
                                missions.add(mission);
                            } catch (IllegalArgumentException iae) {
                            }
                        }
                    }
                    try {
                        soldier = new CommandoImpl(id, firtsName, lastName, salary, corps, missions);
                        break;
                    } catch (IllegalArgumentException iae) {
                    }
                case "Spy":
                    String codeNumber = input[4];
                    soldier = new SpyImpl(id, firtsName, lastName, codeNumber);
                    break;
            }
            if (soldier != null) {
                soldiers.putIfAbsent(id, soldier);
            }
            input = reader.readLine().split("\\s+");
        }

        for (Map.Entry<Integer, Soldier> soldier : soldiers.entrySet()) {
            System.out.println(soldier.getValue());
        }
    }
}
