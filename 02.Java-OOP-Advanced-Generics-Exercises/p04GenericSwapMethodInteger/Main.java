package p04GenericSwapMethodInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Box> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            Box box = new Box(number);
            items.add(box);
        }

        String[] indices = reader.readLine().split("\\s+");

        int index1 = Integer.parseInt(indices[0]);
        int index2 = Integer.parseInt(indices[1]);

        Box.swap(items, index1, index2);

        for (Box box : items) {
            System.out.println(box);
        }
    }
}
