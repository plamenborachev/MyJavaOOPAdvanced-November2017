package p10InfernoInfinity;

public class Sword extends BaseWeapon implements Weapon {

    public Sword(String name) {
        super(name, WeaponType.SWORD.getMinDamage(), WeaponType.SWORD.getMaxDamage(), WeaponType.SWORD.getSockets());
    }
}
