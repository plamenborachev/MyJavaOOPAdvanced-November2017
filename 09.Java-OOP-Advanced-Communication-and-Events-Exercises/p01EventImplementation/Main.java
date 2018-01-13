package p01EventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Dispatcher dispatcher = new Dispatcher("Pesho");
        Handler handler = new Handler();
        dispatcher.addNameChangeListener(handler);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        while (!"End".equals(line)){
            NameChange nameChange = new NameChange(line);
            handler.handleChangedName(nameChange);
            line = reader.readLine();
        }
    }
}
