package p10MooD3;

public class Archangel extends BaseGameObject implements GameObject {
    private Integer mana;

    protected Archangel(String username, Integer level, Integer mana) {
        super(username, level);
        this.mana = mana;
    }

    @Override
    protected String generatePassword() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getUsername()).reverse();
        sb.append(super.getUsername().length() * 21);
        return sb.toString();
    }

    @Override
    public String toString() {
        return super.toString() + this.mana * super.getLevel();
    }
}
