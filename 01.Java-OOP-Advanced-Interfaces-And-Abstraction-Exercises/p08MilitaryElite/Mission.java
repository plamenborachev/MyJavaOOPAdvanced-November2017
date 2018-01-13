package p08MilitaryElite;

public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    public void setState(String state) {
        if (!"inProgress".equals(state) && !"Finished".equals(state)){
            throw new IllegalArgumentException();
        }
        this.state = state;
    }

    public void CompleteMission(){

    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
