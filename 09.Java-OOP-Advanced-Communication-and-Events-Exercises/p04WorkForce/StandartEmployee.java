package p04WorkForce;

public class StandartEmployee extends BaseEmployee{

    private static final int STANDART_EMPLOYEE_WORK_HOURS_PER_WEEK = 40;

    public StandartEmployee(String name) {
        super(name);
        this.setWorkHoursPerWeek(STANDART_EMPLOYEE_WORK_HOURS_PER_WEEK);
    }


}
