package p03Mediator.commands;

import p03Mediator.interfaces.AttackGroup;
import p03Mediator.interfaces.Command;

public class GroupAttackCommand implements Command {

    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        this.group.groupAttack();
    }
}
