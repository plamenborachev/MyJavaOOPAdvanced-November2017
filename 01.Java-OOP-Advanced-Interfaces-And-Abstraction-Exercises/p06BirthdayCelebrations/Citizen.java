package p06BirthdayCelebrations;

public class Citizen extends BaseResident implements Birthday{
    private String name;
    private Integer age;
    private String birthday;

    protected Citizen(String id, String name, Integer age, String birthday) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
