package p10MooD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" \\| ");

        String username = input[0];
        String characterType = input[1];
        Integer level = Integer.parseInt(input[3]);

        GameObject gameObject = null;
        if ("Archangel".equals(characterType)){
            Integer mana = Integer.parseInt(input[2]);
            gameObject = new Archangel(username, level, mana);
        } else if ("Demon".equals(characterType)){
            Double energy = Double.parseDouble(input[2]);
            gameObject = new Demon(username, level, energy);
        }

        System.out.println(gameObject);

    }
}
