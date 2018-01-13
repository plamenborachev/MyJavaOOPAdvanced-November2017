package p02KingsGambit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        King king = new King(reader.readLine());

        for (String royalGuardName : reader.readLine().split("\\s+")) {
            Observer royalGuard = new RoyalGuard(royalGuardName);
            king.attach(royalGuard);
        }

        for (String footmanName : reader.readLine().split("\\s+")) {
            Observer footman = new Footman(footmanName);
            king.attach(footman);
        }

        String[] commandLine = reader.readLine().split("\\s+");

        while (!"End".equals(commandLine[0])){
            switch (commandLine[0]){
                case "Attack":
                    king.update();
                    king.notifyAllObservers();
                    break;
                case "Kill":
                    king.detach(commandLine[1]);
                    break;
            }
            commandLine = reader.readLine().split("\\s+");
        }
    }
}
