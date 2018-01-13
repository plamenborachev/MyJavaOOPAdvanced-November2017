package p08CustomListSorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        CustomList<String> customList = new CustomList();

        while (!input[0].equals("END")){
            switch (input[0]){
                case "Add":
                    customList.add(input[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(input[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(input[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(input[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                case "Print":
                    for (int i = 0; i < customList.getElements().size(); i++) {
                        System.out.println(customList.getElements().get(i));
                    }
                    break;
            }
            input = reader.readLine().split("\\s+");
        }

    }
}
