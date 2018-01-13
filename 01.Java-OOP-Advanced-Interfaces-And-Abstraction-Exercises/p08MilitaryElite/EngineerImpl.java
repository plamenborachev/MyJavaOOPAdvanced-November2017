package p08MilitaryElite;

import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(Integer id, String firstName, String lastName, Double salary, String corps, List<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = repairs;
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
        return super.getCorps();
    }

    @Override
    public List<Repair> getRepairs() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format("Corps: %s", this.getCorps()));
        sb.append(System.lineSeparator());
        sb.append("Repairs:");
        sb.append(System.lineSeparator());
        for (Repair repair : this.repairs) {
            sb.append("  " + repair);
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
