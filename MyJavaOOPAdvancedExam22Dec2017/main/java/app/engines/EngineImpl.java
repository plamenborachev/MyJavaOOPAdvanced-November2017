package app.engines;

import app.contracts.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class EngineImpl implements app.contracts.Engine {
    private static final String TERMINATE_COMMAND = "Peace";

    private Reader reader;
    private Writer writer;
    private Battlefield battleField;

    public EngineImpl(Reader reader, Writer writer, Battlefield battleField) {
        this.reader = reader;
        this.writer = writer;
        this.battleField = battleField;
    }

    @Override
    public void run() throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!line.equals(TERMINATE_COMMAND)) {
            String[] lineTokens = line.split("\\s+");

            switch (lineTokens[0].toLowerCase()) {
                case "createparticipant":
                    battleField.createParticipant(lineTokens[1], lineTokens[2]);
                    break;
                case "createaction":
                    battleField.createAction(lineTokens[1],
                            Arrays.copyOf(Arrays.stream(lineTokens).skip(2).toArray(),
                                    Arrays.stream(lineTokens).skip(2).toArray().length,
                                    String[].class));
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }

            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        while (true) {
//            List<String> tokens = null;
//            try {
//                tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split(" ")));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
//                break;
//            }
//
//            try {
//                String result = this.battleField.(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList
// ()));
//                if (result != null) {
//                    this.writer.writeLine(result);
//                }
//            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
// NoSuchMethodException | InvocationTargetException | IllegalStateException | IllegalArgumentException e) {
//                this.writer.writeLine(e.getMessage());
//            }
//        }
    }
}