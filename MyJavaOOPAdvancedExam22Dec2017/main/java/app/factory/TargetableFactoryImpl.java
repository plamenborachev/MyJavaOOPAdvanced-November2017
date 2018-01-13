package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.models.participants.Heroes.Necromancer;
import app.models.participants.Heroes.Warrior;
import app.models.participants.Heroes.Wizard;

import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {

    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Targetable targetable = null;

        switch (className) {
            case "Warrior":
                targetable = new Warrior();
                targetable.setName(name);
                break;
            case "Wizard":
                targetable = new Wizard();
                targetable.setName(name);
                break;
            case "Necromancer":
                targetable = new Necromancer();
                targetable.setName(name);
                break;
            default:
                System.out.println("Participant class does not exist.");
        }

        return targetable;
    }
}
