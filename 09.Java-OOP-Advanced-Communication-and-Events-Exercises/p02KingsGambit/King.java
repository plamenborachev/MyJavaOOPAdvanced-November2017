package p02KingsGambit;

import java.util.LinkedHashMap;
import java.util.Map;

public class King extends AbstractUnit {

    private Map<String, Observer> observers;

    public King(String name) {
        super(name);
        this.observers = new LinkedHashMap<>();
    }

    @Override
    public void update() {
        System.out.println(String.format("King %s is under attack!", super.getName()));
    }

    public void attach(Observer observer){
        this.observers.putIfAbsent(observer.getName(), observer);
    }

    public void detach(String observer){
        this.observers.remove(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : this.observers.values()) {
            observer.update();
        }
    }
}
