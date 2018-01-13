package p08MilitaryElite;

import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(Integer id, String firstName, String lastName, Double salary, String corps, List<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = missions;
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
    public List<Mission> getMissions() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format("Corps: %s", this.getCorps()));
        sb.append(System.lineSeparator());
        sb.append("Missions:");
        sb.append(System.lineSeparator());
        for (Mission mission : this.missions) {
            sb.append("  " + mission);
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
