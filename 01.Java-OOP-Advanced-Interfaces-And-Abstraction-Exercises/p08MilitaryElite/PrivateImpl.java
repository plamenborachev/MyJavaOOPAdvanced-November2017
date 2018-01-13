package p08MilitaryElite;

public class PrivateImpl extends SoldierImpl implements Private {
    private Double salary;

    public PrivateImpl(Integer id, String firstName, String lastName, Double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
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
        return this.salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Salary: %.2f", this.getSalary());
    }
}
