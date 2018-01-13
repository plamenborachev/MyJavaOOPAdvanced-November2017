package p03Mediator;

import p03Mediator.commands.AttackCommand;
import p03Mediator.commands.TargetCommand;
import p03Mediator.implementations.CommandExecutor;
import p03Mediator.implementations.Dragon;
import p03Mediator.implementations.Warrior;
import p03Mediator.interfaces.*;
import p03Mediator.loggers.CombatLogger;
import p03Mediator.loggers.EventLogger;

public class Main {
    public static void main(String[] args) {

        Handler combatLog = new CombatLogger();
        Handler eventLog = new EventLogger();

        combatLog.setSuccessor(eventLog);

        Attacker warrior = new Warrior("p02Command.Warrior", 10, combatLog);
        Target dragon = new Dragon("p02Command.Dragon", 10, 25, combatLog);

        Executor executor = new CommandExecutor();

        Command target = new TargetCommand(warrior, dragon);
        Command attack = new AttackCommand(warrior);

        executor.executeCommand(target);
        executor.executeCommand(attack);

        combatLog.handle(LogType.ATTACK, "some attack");
        combatLog.handle(LogType.ERROR, "some attack");
        combatLog.handle(LogType.EVENT, "some attack");
    }
}
