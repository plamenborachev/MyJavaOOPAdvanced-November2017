package p08MilitaryElite;

import java.util.List;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private List<Soldier> privates;

    public LeutenantGeneralImpl(Integer id, String firstName, String lastName, Double salary, List<Soldier> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
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
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append("Privates:");
        sb.append(System.lineSeparator());
        this.privates.stream()
                .sorted((p1, p2) -> p2.getId().compareTo(p1.getId()))
                .forEach(p -> sb.append("  ").append(p).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    @Override
    public List<Private> getPrivates() {
        return null;
    }
}
