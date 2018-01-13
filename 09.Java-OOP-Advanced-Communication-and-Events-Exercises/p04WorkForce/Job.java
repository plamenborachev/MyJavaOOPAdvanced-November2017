package p04WorkForce;

public class Job implements Observer {

    private String name;
    private int hoursOfWorkRequired;
    private Employee employee;
    private Company company;


    public Job(String name, int hoursOfWorkRequired, Employee employee, Company company) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employee = employee;
        this.company = company;
    }

    @Override
    public void update(){
        this.hoursOfWorkRequired -= this.employee.getWorkHoursPerWeek();

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHoursOfWorkRequired() {
        return this.hoursOfWorkRequired;
    }
}
