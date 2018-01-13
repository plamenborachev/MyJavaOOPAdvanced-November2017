package p03Mediator.commands;

import p03Mediator.interfaces.Attacker;
import p03Mediator.interfaces.Command;

public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}
