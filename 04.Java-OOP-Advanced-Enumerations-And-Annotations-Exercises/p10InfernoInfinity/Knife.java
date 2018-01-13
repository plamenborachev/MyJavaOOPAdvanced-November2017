package p10InfernoInfinity;

public class Knife extends BaseWeapon implements Weapon {

    public Knife(String name) {
        super(name, WeaponType.KNIFE.getMinDamage(), WeaponType.KNIFE.getMaxDamage(), WeaponType.KNIFE.getSockets());
    }
}
