package app.models.participants.Bosses;

import app.contracts.Targetable;
import app.models.Config;

public class Boss implements Targetable {

    private String name;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;

    public Boss(String name) {
        this.name = name;
        this.health = Config.BOSS_HEALTH;
        this.damage = Config.BOSS_DAMAGE;
        this.gold = Config.BOSS_GOLD;
        this.isAlive = true;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(double health) {

    }

    @Override
    public double getGold() {
        return this.gold;
    }


    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public String attack(Targetable target) {
        return null;
    }

    @Override
    public void takeDamage(double damage) {

    }

    @Override
    public void giveReward(Targetable targetable) {

    }

    @Override
    public void receiveReward(double reward) {

    }

    @Override
    public void levelUp() {

    }
}
