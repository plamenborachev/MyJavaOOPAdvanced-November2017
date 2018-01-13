package app.models.participants.Heroes;

import app.models.Config;

public class Wizard extends BaseHero {


    public Wizard() {
        super.setStrength(Config.WIZARD_BASE_STRENGTH);
        super.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        super.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return super.getIntelligence() * 5 + super.getDexterity();
    }
}
