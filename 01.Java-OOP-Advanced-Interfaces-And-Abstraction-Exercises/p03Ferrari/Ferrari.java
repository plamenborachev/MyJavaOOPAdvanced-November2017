package p03Ferrari;

public class Ferrari implements Car {
    public final String MODEL = "488-Spider";
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    @Override
    public String getModel() {
        return this.MODEL;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushTheGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.getModel(), this.useBrakes(), this.pushTheGasPedal(), this.getDriver());
    }
}
