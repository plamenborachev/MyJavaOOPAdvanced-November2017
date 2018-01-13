package p04Observer.implementations;

import p04Observer.LogType;
import p04Observer.abstractClasses.AbstractHero;
import p04Observer.interfaces.Handler;
import p04Observer.interfaces.Target;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
        super.getHandler().handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }


    @Override
    public void update(int val) {
        super.getHandler().handle(LogType.EVENT, super.getId() + " earns " + val);
    }
}
