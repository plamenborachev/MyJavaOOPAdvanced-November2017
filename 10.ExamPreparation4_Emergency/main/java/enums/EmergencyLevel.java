package enums;

public enum EmergencyLevel {
    MINOR,
    MAJOR,
    DISASTER;

    @Override
    public String toString() {
        char first = this.name().charAt(0);
        String rest = this.name().substring(1).toLowerCase();
        return first + rest;
    }
}
