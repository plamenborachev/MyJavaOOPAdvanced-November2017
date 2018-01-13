package p08MilitaryElite;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    protected SpyImpl(Integer id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d",
                this.getFirstName(),
                this.getLastName(),
                this.getId()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Code Number: %s", this.getCodeNumber()));
        return sb.toString();
    }
}
