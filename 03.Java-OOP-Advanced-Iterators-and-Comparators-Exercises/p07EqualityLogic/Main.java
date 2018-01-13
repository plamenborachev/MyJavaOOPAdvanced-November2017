package p07EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Set<Person> peopleTreeSet = new TreeSet<>();
        Set<Person> peopleHashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            Integer age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            peopleTreeSet.add(person);
            peopleHashSet.add(person);
        }

        System.out.println(peopleTreeSet.size());
        System.out.println(peopleHashSet.size());
    }
}
