package p05BorderControl;

public class Citizen extends BaseResident {
    private String name;
    private Integer age;

    protected Citizen(String id, String name, Integer age) {
        super(id);
        this.name = name;
        this.age = age;
    }
}
