package models.centers;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public interface EmergencyCenter {
    void processEmergency();

    String getName();

    Integer getAmountOfMaximumEmergencies();

    Boolean isForRetirement();
}
