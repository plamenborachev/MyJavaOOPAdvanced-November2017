package p02MultipleImplementation;

public class Citizen implements Identifiable, Birthable {
    private String name;
    private Integer age;
    private String id;
    private String birthday;

    public Citizen(String name, Integer age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getBirthday() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}
