package p03StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] command = reader.readLine().split("[, ]+");
        Stack<Integer> stack = new Stack<>();

        while (!"END".equals(command[0])) {
            switch (command[0]) {
                case "Push":
                    List<Integer> numbers = Arrays.stream(command)
                            .skip(1L).map(Integer::parseInt)
                            .collect(Collectors.toList());
                    for (Integer number : numbers) {
                        stack.push(number);
                    }
                    break;
                case "Pop":
                    try{
                        stack.pop();
                    } catch (IndexOutOfBoundsException iobe){
                        System.out.println(iobe.getMessage());
                    }
                    break;
            }
            command = reader.readLine().split("\\s+");
        }
        System.out.println(stack.print());
    }
}
