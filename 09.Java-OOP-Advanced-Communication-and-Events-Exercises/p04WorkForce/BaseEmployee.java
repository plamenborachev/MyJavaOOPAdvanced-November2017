package p04WorkForce;

public abstract class BaseEmployee implements Employee {
    private String name;
    private int workHoursPerWeek;

    protected BaseEmployee(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected void setWorkHoursPerWeek(int workHoursPerWeek) {
        this.workHoursPerWeek = workHoursPerWeek;
    }

    @Override
    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}
