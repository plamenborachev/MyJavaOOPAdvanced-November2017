package p02KingsGambit;

public class RoyalGuard extends AbstractUnit {
    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void update() {
        System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
    }
}
