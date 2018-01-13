package panzer.models.Parts;

import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class ArsenalPart extends BasePart implements AttackModifyingPart{

    private int attackModifier;

    public ArsenalPart(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Part - %s", this.getClass().getSimpleName(), super.getModel()))
                .append(System.lineSeparator());
        sb.append(String.format("+%d Attack", this.attackModifier));
        return sb.toString();
    }
}
