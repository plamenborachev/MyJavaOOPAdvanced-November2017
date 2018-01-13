package p10InfernoInfinity;

public class Axe extends BaseWeapon implements Weapon {

    public Axe(String name) {
        super(name, WeaponType.AXE.getMinDamage(), WeaponType.AXE.getMaxDamage(), WeaponType.AXE.getSockets());
    }
}
