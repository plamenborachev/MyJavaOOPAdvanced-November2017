package p05BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        List<Identifiable> residents = new ArrayList<>();

        while(!"End".equals(input[0])){
            Identifiable identifiable = null;
            if(input.length == 3){
                String name = input[0];
                Integer age = Integer.parseInt(input[1]);
                String id = input[2];
                identifiable = new Citizen(id, name, age);
            } else {
                String model = input[0];
                String id = input[1];
                identifiable = new Robot(id, model);
            }
            residents.add(identifiable);

            input = reader.readLine().split("\\s+");
        }

        String lastDigits = reader.readLine();

        for (Identifiable rsidents: residents) {
            if (rsidents.getId().endsWith(lastDigits)){
                System.out.println(rsidents.getId());
            }
        }
    }
}
