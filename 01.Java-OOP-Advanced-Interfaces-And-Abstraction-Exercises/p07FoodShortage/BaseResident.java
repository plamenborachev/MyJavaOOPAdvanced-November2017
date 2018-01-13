package p07FoodShortage;

public class BaseResident implements Identifiable {
    private String id;

    protected BaseResident(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
