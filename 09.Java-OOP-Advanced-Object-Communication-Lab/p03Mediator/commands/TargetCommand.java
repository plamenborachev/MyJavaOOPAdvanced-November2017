package p03Mediator.commands;

import p03Mediator.interfaces.Attacker;
import p03Mediator.interfaces.Command;
import p03Mediator.interfaces.Target;

public class TargetCommand implements Command {

    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
    }
}
