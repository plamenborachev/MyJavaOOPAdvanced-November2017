package p06StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Set<Person> peopleByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleByAge = new TreeSet<>(new AgeComparator());

        for (int i = 0; i < n; i++) {
            String[] personTokens = reader.readLine().split("\\s+");
            String name = personTokens[0];
            Integer age = Integer.valueOf(personTokens[1]);
            Person person = new Person(name, age);

            peopleByName.add(person);
            peopleByAge.add(person);
        }

        for (Person person : peopleByName) {
            System.out.println(person);
        }

        for (Person person : peopleByAge) {
            System.out.println(person);
        }
    }
}
