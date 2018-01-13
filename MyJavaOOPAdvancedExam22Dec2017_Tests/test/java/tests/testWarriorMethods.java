package tests;

import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testWarriorMethods {
    private Warrior warrior;

    @Before
    public void before(){
        this.warrior = new Warrior();
    }

    @Test
    public void getStrengthTest(){
        Assert.assertEquals(5, this.warrior.getStrength());
    }

    @Test
    public void getDexterityTest(){
        Assert.assertEquals(4, this.warrior.getDexterity());
    }

    @Test
    public void getIntelligenceTest(){
        Assert.assertEquals(1, this.warrior.getIntelligence());
    }

    @Test
    public void setDexterityTest(){
        this.warrior.setDexterity(10);
        Assert.assertEquals(10, this.warrior.getDexterity());
    }

    @Test
    public void getDamageTest(){
        Assert.assertEquals(14.0, this.warrior.getDamage(), 0.0);
    }

    @Test
    public void isAliveTest(){
        Assert.assertTrue(this.warrior.isAlive());
    }

    @Test
    public void levelUpChangesStrength(){
        this.warrior.levelUp();
        Assert.assertEquals(10, this.warrior.getStrength());
    }

    @Test
    public void testReceiveReward(){
        this.warrior.receiveReward(100.0);
        Assert.assertEquals(300.0, this.warrior.getGold(), 0.0);
    }




}
