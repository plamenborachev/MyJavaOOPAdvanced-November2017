package p09TrafficLights;

public enum TrafficLight {
    RED, GREEN, YELLOW;

    private static TrafficLight[] vals = values();

    public TrafficLight next() {
        return vals[(this.ordinal() + 1) % vals.length];
    }
}
