package p07_1984.contracts;

import p07_1984.models.BaseSubject;

import java.util.Map;

public interface Observer extends ConspiracyObjects {

    void attachToSubjects(Map<String, Observable> subjects);

    void update(BaseSubject subject, String property, String oldValue, String newValue);
}
