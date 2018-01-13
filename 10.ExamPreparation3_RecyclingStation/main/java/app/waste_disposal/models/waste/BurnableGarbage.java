package app.waste_disposal.models.waste;

public class BurnableGarbage extends BaseWaste {
    protected BurnableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
