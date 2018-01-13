package app.waste_disposal.models.processing_data;

import app.waste_disposal.contracts.ProcessingData;

public class ProcessingDataImpl implements ProcessingData {

    private double energyBalance;
    private double capitalBalance;


    @Override
    public double getEnergyBalance() {
        return 0;
    }

    @Override
    public double getCapitalBalance() {
        return 0;
    }
}
