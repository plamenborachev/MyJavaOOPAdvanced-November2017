package p07_1984.models;

import p07_1984.annotations.ObservableField;

public class Employee extends BaseSubject {

    @ObservableField
    private int income;

    public Employee(String id, String name, int income) {
        super(id, name);
        this.income = income;
    }
}
