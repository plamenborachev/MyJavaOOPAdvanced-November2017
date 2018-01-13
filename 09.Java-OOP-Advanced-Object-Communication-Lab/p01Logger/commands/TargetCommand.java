package p01Logger.commands;

import p01Logger.interfaces.Attacker;
import p01Logger.interfaces.Command;
import p01Logger.interfaces.Target;

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
