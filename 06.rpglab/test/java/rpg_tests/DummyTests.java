package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;
import rpg_lab.Target;

public class DummyTests {

    public static final int DUMMY_HEALTH = 10;
    public static final int DUMMY_EXPERIENCE = 10;
    public static final int ATTACK_POINTS = 5;
    public static final int EXPECTED_HEALTH = 5;
    public static final int EXPECTED_EXPERIENCE = 10;
    private Target dummy;

    @Before
    public void initializeDummy(){
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthIfAttacked(){
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals("Wrong health",EXPECTED_HEALTH, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyAttacked(){
        while (dummy.getHealth() >= 0){
            dummy.takeAttack(ATTACK_POINTS);
        }
    }

    @Test
    public void deadDummyCanGiveXP(){
        dummy.takeAttack(DUMMY_HEALTH);
        dummy.giveExperience();
        Assert.assertEquals("Wrong XP",EXPECTED_EXPERIENCE, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP(){
        dummy.giveExperience();
    }
}
