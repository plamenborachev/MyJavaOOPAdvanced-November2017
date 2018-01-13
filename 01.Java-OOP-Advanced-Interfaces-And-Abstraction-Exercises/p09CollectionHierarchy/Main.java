package p09CollectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        AddCollection<String> addCollection = new AddCollectionImpl<>();
        AddRemoveCollection<String> addRemoveCollection = new AddRemoveCollectionImpl();
        MyList<String> myList = new MyListImpl();

        List<Integer> firstOutputLine = new ArrayList<>();
        List<Integer> secondOutputLine = new ArrayList<>();
        List<Integer> thirdOutputLine = new ArrayList<>();


        for (String word : input) {
            firstOutputLine.add(addCollection.add(word));
            secondOutputLine.add(addRemoveCollection.add(word));
            thirdOutputLine.add(myList.add(word));
        }

        int amountOfRemoveOperations = Integer.parseInt(reader.readLine());

        List<String> fourthOutputLine = new ArrayList<>();
        List<String> fifthOutputLine = new ArrayList<>();

        for (int i = 0; i < amountOfRemoveOperations; i++) {
            fourthOutputLine.add(addRemoveCollection.Remove());
            fifthOutputLine.add(myList.Remove());
        }

        System.out.println(firstOutputLine.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(secondOutputLine.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(thirdOutputLine.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(fourthOutputLine.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(fifthOutputLine.toString().replaceAll("[\\[\\],]", ""));
    }
}
