package p01ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        ListyIterator<String> listyIterator = null;

        while (!"END".equals(input[0])){
            switch (input[0]){
                case "Create":
                    String[] strings = Arrays.stream(input).skip(1L).toArray(String[]::new);
                    listyIterator = new ListyIterator(strings);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try{
                        listyIterator.print();
                    } catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
            input = reader.readLine().split("\\s+");
        }
    }
}
