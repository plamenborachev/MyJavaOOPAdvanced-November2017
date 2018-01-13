package p02KingsGambit;

public class Footman extends AbstractUnit {
    public Footman(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println(String.format("Footman %s is panicking!", super.getName()));
    }
}
