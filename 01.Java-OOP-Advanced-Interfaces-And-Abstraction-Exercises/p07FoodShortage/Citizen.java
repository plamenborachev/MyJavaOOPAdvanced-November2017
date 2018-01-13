package p07FoodShortage;

public class Citizen extends BaseResident implements Birthday, Buyer {
    private String name;
    private Integer age;
    private String birthday;
    private Integer food;

    protected Citizen(String id, String name, Integer age, String birthday) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.food = 0;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public Integer getFood() {
        return this.food;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }
}
