package p05KingsGambitExtended.events;

import p05KingsGambitExtended.contracts.Observer;
import p05KingsGambitExtended.contracts.Subject;
import p05KingsGambitExtended.contracts.Observer;

public class KillEvent {

    public void executeEvent(Observer observer, Subject subject) {
        observer.takeHit();

        if(observer.getHealth() <= 0) {
            subject.removeObserver(observer);
        }
    }
}
