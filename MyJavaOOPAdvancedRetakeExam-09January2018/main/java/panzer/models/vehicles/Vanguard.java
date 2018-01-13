package panzer.models.vehicles;

import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {

    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight, price, attack, defense, hitPoints);
    }

    @Override
    protected void setWeight(double weight) {
        super.setWeight(weight * 200 / 100);
    }

    @Override
    protected void setAttack(int attack) {
        super.setAttack(attack * 75 / 100);
    }

    @Override
    protected void setDefense(int defense) {
        super.setDefense(defense * 150 / 100);
    }

    @Override
    protected void setHitPoints(int hitPoints) {
        super.setHitPoints(hitPoints * 175 / 100);
    }
}
