package p08MilitaryElite;

public abstract class SoldierImpl implements Soldier {
    private Integer id;
    private String firstName;
    private String lastName;

    protected SoldierImpl(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d",
                this.getFirstName(), this.getLastName(), this.getId());
    }
}
