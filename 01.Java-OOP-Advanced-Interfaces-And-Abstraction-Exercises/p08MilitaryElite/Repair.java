package p08MilitaryElite;

public class Repair {
    private String partName;
    private Integer hoursWorked;

    public Repair(String partName, Integer hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.partName, this.hoursWorked);
    }
}
