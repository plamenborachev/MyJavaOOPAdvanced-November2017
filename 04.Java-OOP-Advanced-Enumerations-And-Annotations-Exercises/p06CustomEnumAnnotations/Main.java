package p06CustomEnumAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CardInfo crd = null;

        switch (reader.readLine()){
            case "Rank":
                crd = CardRanks.class.getAnnotation(CardInfo.class);
                System.out.println(String.format("Type = %s, Description = %s",
                        crd.type(), crd.description()));
                break;
            case "Suit":
                crd = CardSuits.class.getAnnotation(CardInfo.class);
                System.out.println(String.format("Type = %s, Description = %s",
                        crd.type(), crd.description()));
                break;
        }
    }
}
