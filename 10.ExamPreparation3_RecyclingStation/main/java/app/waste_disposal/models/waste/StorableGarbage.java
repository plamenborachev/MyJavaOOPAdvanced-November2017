package app.waste_disposal.models.waste;

public class StorableGarbage extends BaseWaste {
    protected StorableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
