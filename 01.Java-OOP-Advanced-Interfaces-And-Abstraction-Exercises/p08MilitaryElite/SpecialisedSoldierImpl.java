package p08MilitaryElite;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private String corps;

    public SpecialisedSoldierImpl(Integer id, String firstName, String lastName, Double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    public void setCorps(String corps) {
        if (!"Airforces".equals(corps) && !"Marines".equals(corps)){
            throw new IllegalArgumentException();
        }
        this.corps = corps;
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public Double getSalary() {
        return super.getSalary();
    }

    @Override
    public String getCorps() {
        return this.corps;
    }
}
