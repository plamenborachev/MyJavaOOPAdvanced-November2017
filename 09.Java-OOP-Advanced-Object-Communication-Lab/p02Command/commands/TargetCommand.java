package p02Command.commands;

import p02Command.interfaces.Attacker;
import p02Command.interfaces.Command;
import p02Command.interfaces.Target;

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
