package p10MooD3;

public abstract class BaseGameObject implements GameObject {
    private String username;
    private String hashedPassword;
    private Integer level;

    protected BaseGameObject(String username, Integer level) {
        this.username = username;
        this.hashedPassword = this.generatePassword();
        this.level = level;
    }

    protected abstract String generatePassword();

    protected String getUsername() {
        return this.username;
    }

    protected String getHashedPassword() {
        return this.hashedPassword;
    }

    protected Integer getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n",
                this.username,
                this.hashedPassword,
                this.getClass().getSimpleName());
    }
}
