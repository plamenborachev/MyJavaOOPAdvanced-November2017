package enumeration;

public enum EngineType {

    JET, STERNDRIVE;

    @Override
    public String toString() {
        return this.name();
    }
}
