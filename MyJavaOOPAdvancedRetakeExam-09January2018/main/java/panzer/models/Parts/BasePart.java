package panzer.models.Parts;

import panzer.contracts.Part;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class BasePart implements Part {

    private String model;
    private double weight;
    private BigDecimal price;

    protected BasePart(String model, double weight, BigDecimal price) {
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }


}
