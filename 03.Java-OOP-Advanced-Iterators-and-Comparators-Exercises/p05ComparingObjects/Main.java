package p05ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] command =reader.readLine().split("\\s+");

        Map<Integer, Person> people = new LinkedHashMap<>();
        int counter = 1;
        while (!"END".equals(command[0])){

            String name = command[0];
            Integer age = Integer.parseInt(command[1]);
            String town = command[2];

            Person person = new Person(name, age, town);

            people.put(counter, person);
            counter++;

            command =reader.readLine().split("\\s+");
        }

        int num = Integer.parseInt(reader.readLine());

        Person personForComparison = people.get(num);

        int numberOfEqualPeople = 0;
        int numberOfNotEqualPeople = 0;

        for (Person person : people.values()) {
            if (person.compareTo(personForComparison) == 0){
                numberOfEqualPeople++;
            } else {
                numberOfNotEqualPeople++;
            }
        }

        if (numberOfEqualPeople == 1){
            System.out.println("No matches");
        } else {
            System.out.println(numberOfEqualPeople + " " + numberOfNotEqualPeople + " " + people.size());
        }

    }
}
