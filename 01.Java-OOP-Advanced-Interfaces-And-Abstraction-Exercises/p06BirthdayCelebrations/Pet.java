package p06BirthdayCelebrations;

public class Pet implements Birthday {
    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
