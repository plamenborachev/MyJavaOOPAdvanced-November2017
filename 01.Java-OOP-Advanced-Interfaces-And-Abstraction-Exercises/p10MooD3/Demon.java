package p10MooD3;

public class Demon extends BaseGameObject implements GameObject {
    private Double energy;

    protected Demon(String username, Integer level, Double energy) {
        super(username, level);
        this.energy = energy;
    }

    @Override
    protected String generatePassword() {
        return String.valueOf(super.getUsername().length() * 217);
    }

    @Override
    public String toString() {
        return super.toString() + this.energy * super.getLevel();
    }
}
