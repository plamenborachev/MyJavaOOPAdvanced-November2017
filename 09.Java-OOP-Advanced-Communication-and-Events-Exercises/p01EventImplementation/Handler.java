package p01EventImplementation;

public class Handler implements NameChangeListener{
    @Override
    public void handleChangedName(NameChange event) {
        System.out.println(String.format("Dispatcher's name changed to %s.", event.getChangedName()));
    }
}
