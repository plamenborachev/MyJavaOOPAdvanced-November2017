package p02KingsGambit;

public abstract class AbstractUnit implements Observer{
    private String name;

    protected AbstractUnit(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
