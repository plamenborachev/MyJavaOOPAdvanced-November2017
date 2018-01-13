package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class AxeTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    public static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private Weapon axe;
    private Target dummy;

    @Before
    public void initializeObjects(){
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void weaponLosesDurabilityAfterAttack(){
        this.axe.attack(dummy);
        Assert.assertEquals("Wrong durability", EXPECTED_DURABILITY, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attackingWithBrokenWeapon(){
        while (this.axe.getDurabilityPoints() > 0){
            this.axe.attack(dummy);
        }
    }
}
