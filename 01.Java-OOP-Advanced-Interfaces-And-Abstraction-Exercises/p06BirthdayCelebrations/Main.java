package p06BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        List<Birthday> residentsWithBirthday = new ArrayList<>();
        List<Identifiable> residentsWithId = new ArrayList<>();

        while(!"End".equals(input[0])){
            if("Citizen".equals(input[0])){
                String name = input[1];
                Integer age = Integer.parseInt(input[2]);
                String id = input[3];
                String birthday = input[4];
                Birthday citizen = new Citizen(id, name, age, birthday);
                residentsWithBirthday.add(citizen);
            } else if("Robot".equals(input[0])){
                String model = input[1];
                String id = input[2];
                Identifiable robot = new Robot(id, model);
                residentsWithId.add(robot);
            } else if("Pet".equals(input[0])){
                String name = input[1];
                String birthday = input[2];
                Birthday pet = new Pet(name, birthday);
                residentsWithBirthday.add(pet);
            }
            input = reader.readLine().split("\\s+");
        }

        String birthdayYear = reader.readLine();

        for (Birthday residents: residentsWithBirthday) {
            if (residents.getBirthday().endsWith(birthdayYear)){
                System.out.println(residents.getBirthday());
            }
        }
    }
}
