package factory;


import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class TimeFactory {
    public static RegistrationTime create(String time) {
        return new RegistrationTimeImpl(time);
    }
}
