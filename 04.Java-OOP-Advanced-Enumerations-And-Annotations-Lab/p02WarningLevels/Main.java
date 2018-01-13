package p02WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String importance = reader.readLine();

        String[] inputMessage = reader.readLine().split(": ");

        Logger logger = new Logger(Importance.valueOf(importance));

        while (!"END".equals(inputMessage[0])){
            String level = inputMessage[0];
            String content = inputMessage[1];
            Message message = new Message(Importance.valueOf(level), content);
            logger.recordMessage(message);

            inputMessage = reader.readLine().split(": ");
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
