package p04WorkForce;

public class PartTimeEmployee extends BaseEmployee {

    private static final int PART_TIME_EMPLOYEE_WORK_HOURS_PER_WEEK = 20;

    protected PartTimeEmployee(String name) {
        super(name);
        this.setWorkHoursPerWeek(PART_TIME_EMPLOYEE_WORK_HOURS_PER_WEEK);
    }


}
