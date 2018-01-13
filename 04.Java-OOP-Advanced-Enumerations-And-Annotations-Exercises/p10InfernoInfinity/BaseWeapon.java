package p10InfernoInfinity;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class BaseWeapon implements Weapon {
    private String name;
    private int minDamage;
    private int maxDamage;
    private int maxSockets;
    private GemType[] gems;
    private int strength;
    private int agility;
    private int vitality;

    protected BaseWeapon(String name, int minDamage, int maxDamage, int maxSockets) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.maxSockets = maxSockets;
        this.gems = new GemType[this.maxSockets];
    }

    public String getName() {
        return this.name;
    }

    public int getMinDamage() {
        for (int i = 0; i < this.gems.length; i++) {
            if (this.gems[i] != null) {
                this.minDamage += 2 * this.gems[i].getStrength() + this.gems[i].getAgility();
            }
        }
        return this.minDamage;
    }

    public int getMaxDamage() {
        for (int i = 0; i < this.gems.length; i++) {
            if (this.gems[i] != null) {
                this.maxDamage += 3 * this.gems[i].getStrength() + 4 * this.gems[i].getAgility();
            }
        }
        return this.maxDamage;
    }

    public int getStrength() {
        for (GemType gem : this.gems) {
            if (gem != null) {
                this.strength += gem.getStrength();
            }
        }
        return this.strength;
    }

    public int getAgility() {
        for (GemType gem : this.gems) {
            if (gem != null) {
                this.agility += gem.getAgility();
            }
        }
        return this.agility;
    }

    public int getVitality() {
        for (GemType gem : this.gems) {
            if (gem != null) {
                this.vitality += gem.getVitality();
            }
        }
        return this.vitality;
    }

    @Override
    public void addGem(String gemType, int index) {
        if (index < 0
                || this.gems.length <= index
                || !Arrays.stream(GemType.values())
                .map(GemType::name)
                .collect(Collectors.toList())
                .contains(gemType.toUpperCase())) {
            return;
        }
        if (this.gems[index] != null) {
            this.removeStats(this.gems[index]);
        }
        this.gems[index] = GemType.valueOf(gemType.toUpperCase());
        this.addStats(this.gems[index]);
    }

    @Override
    public void removeGem(int index) {
        if (index < 0 || this.gems.length <= index || this.gems[index] == null) {
            return;
        }
        this.removeStats(this.gems[index]);
        this.gems[index] = null;
    }

    private void addStats(GemType gem) {
        this.strength += gem.getStrength();
        this.agility += gem.getAgility();
        this.vitality += gem.getVitality();
        this.minDamage += (gem.getStrength() * 2) + gem.getAgility();
        this.maxDamage += (gem.getStrength() * 3) + (gem.getAgility() * 4);
    }

    private void removeStats(GemType gem) {
        this.strength -= gem.getStrength();
        this.agility -= gem.getAgility();
        this.vitality -= gem.getVitality();
        this.minDamage -= (gem.getStrength() * 2) + gem.getAgility();
        this.maxDamage -= (gem.getStrength() * 3) + (gem.getAgility() * 4);
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, this.minDamage, this.maxDamage,
                this.strength, this.agility, this.vitality);
    }
}
