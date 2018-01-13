package p10InfernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] command = reader.readLine().split(";");

        Map<String, Weapon> weapons = new HashMap<>();

        while (!"END".equals(command[0])){
            switch (command[0]){
                case "Create":
                    String weaponType = command[1];
                    String weaponName = command[2];
                    Weapon weapon = null;
                    switch (weaponType){
                        case "AXE":
                            weapon = new Axe(weaponName);
                            break;
                        case "SWORD":
                            weapon = new Sword(weaponName);
                            break;
                        case "KNIFE":
                            weapon = new Knife(weaponName);
                            break;
                    }
                    weapons.putIfAbsent(weaponName, weapon);
                    break;
                case "Add":
                    weaponName = command[1];
                    int socketIndex = Integer.parseInt(command[2]);
                    String gemType = command[3];
                    if (weapons.containsKey(weaponName)){
                        weapons.get(weaponName).addGem(gemType, socketIndex);
                    }
                    break;
                case "Remove":
                    weaponName = command[1];
                    socketIndex = Integer.parseInt(command[2]);
                    if (weapons.containsKey(weaponName)){
                        weapons.get(weaponName).removeGem(socketIndex);
                    }
                    break;
                case "Print":
                    weaponName = command[1];
                    if (weapons.containsKey(weaponName)){
                        System.out.println(weapons.get(weaponName));
                    }
                    break;
            }
            command = reader.readLine().split(";");
        }
    }
}
