package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class aClass = RichSoilLand.class;
        Field[] fields = aClass.getDeclaredFields();
        String command = reader.readLine();

        while (!"HARVEST".equals(command)) {
            switch (command) {
                case "private":
                    for (Field field : fields) {
                        if (Modifier.isPrivate(field.getModifiers())) {
                            printField(field);
                        }
                    }
                    break;
                case "protected":
                    for (Field field : fields) {
                        if (Modifier.isProtected(field.getModifiers())) {
                            printField(field);
                        }
                    }
                    break;
                case "public":
                    for (Field field : fields) {
                        if (Modifier.isPublic(field.getModifiers())) {
                            printField(field);
                        }
                    }
                    break;
                case "all":
                    for (Field field : fields) {
                        printField(field);
                    }
                    break;
            }
            command = reader.readLine();
        }
    }

    private static void printField(Field field) {
        System.out.println(String.format("%s %s %s",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName()));
    }
}
