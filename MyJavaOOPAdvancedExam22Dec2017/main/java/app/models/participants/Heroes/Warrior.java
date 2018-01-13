package app.models.participants.Heroes;

import app.models.Config;

public class Warrior extends BaseHero {

    public Warrior() {
        super.setStrength(Config.WARRIOR_BASE_STRENGTH);
        super.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
        super.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
    }


    @Override
    public double getDamage() {
        return super.getStrength() * 2 + super.getDexterity();
    }
}
