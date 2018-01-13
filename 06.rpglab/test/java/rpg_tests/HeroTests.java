package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTests {

    public static final int TARGET_XP = 10;
    public static final int ATTACK_POINTS = 10;
    public static final String HERO_NAME = "Pesho";

    @Test
    public void heroGainsExperienceWhenTargetDies(){
        Target fakeTarget = new Target() {
            public int getHealth() {
                return 0;
            }

            public void takeAttack(int attackPoints) {

            }

            public int giveExperience() {
                return TARGET_XP;
            }

            public boolean isDead() {
                return true;
            }
        };

        Weapon fakeWeapon = new Weapon() {
            public int getAttackPoints() {
                return ATTACK_POINTS;
            }

            public int getDurabilityPoints() {
                return 0;
            }

            public void attack(Target target) {

            }
        };

        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals("Wrong XP", TARGET_XP, hero.getExperience());
    }

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Target targetMock = Mockito.mock(Target.class);
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);
        Assert.assertEquals("Wrong XP", TARGET_XP, hero.getExperience());
    }
}
