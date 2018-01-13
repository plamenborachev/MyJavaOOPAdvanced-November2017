package factory;


import models.centers.EmergencyCenter;
import models.centers.FiremanServiceCenter;
import models.centers.MedicalServiceCenter;
import models.centers.PoliceServiceCenter;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CenterFactory {
    public static EmergencyCenter create(String type, String name, Integer additionalParam) {
        switch (type) {
            case "Fire":
                return new FiremanServiceCenter(name, additionalParam);
            case "Police":
                return new PoliceServiceCenter(name, additionalParam);
            case "Medical":
                return new MedicalServiceCenter(name, additionalParam);
            default:
                return null;
        }
    }
}
