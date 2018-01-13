package panzer;

import panzer.contracts.Manager;
import panzer.controllers.ManagerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Manager manager = new ManagerImpl();

        String[] input = reader.readLine().split("\\s+");

        List<String> commandTokens = Arrays.stream(input)
                .collect(Collectors.toList())
                .subList(1, input.length);

        while (!"Terminate".equals(input[0])){
            commandTokens = Arrays.stream(input)
                    .collect(Collectors.toList())
                    .subList(1, input.length);
            switch (input[0]){
                case "Vehicle":
                    System.out.println(manager.addVehicle(commandTokens));
                    break;
                case "Part":
                    System.out.println(manager.addPart(commandTokens));
                    break;
                case "Inspect":
                    System.out.println(manager.inspect(commandTokens));
                    break;
                case "Battle":
                    System.out.println(manager.battle(commandTokens));
                    break;
            }
            input = reader.readLine().split("\\s+");
        }

        System.out.println(manager.terminate(commandTokens));
    }
}
