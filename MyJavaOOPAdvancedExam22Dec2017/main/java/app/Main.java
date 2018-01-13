package app;

import app.contracts.ActionFactory;
import app.contracts.Battlefield;
import app.contracts.TargetableFactory;
import app.core.BattlefieldImplementation;
import app.engines.EngineImpl;
import app.factory.ActionFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        ActionFactory actionFactory = new ActionFactoryImpl();
        TargetableFactory targetableFactory = new TargetableFactoryImpl();
        Battlefield battleField = new BattlefieldImplementation(writer, actionFactory, targetableFactory);
        EngineImpl engine = new EngineImpl(reader, writer, battleField);
        engine.run();
    }
}
