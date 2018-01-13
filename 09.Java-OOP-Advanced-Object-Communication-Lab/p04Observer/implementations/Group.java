package p04Observer.implementations;

import p04Observer.interfaces.AttackGroup;
import p04Observer.interfaces.Attacker;
import p04Observer.interfaces.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {

    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {
        for (Attacker attacker : attackers) {
            attacker.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : attackers) {
            attacker.attack();
        }
    }
}
