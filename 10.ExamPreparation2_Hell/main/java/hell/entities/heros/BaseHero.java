package hell.entities.heros;

import hell.entities.miscellaneous.ItemCollection;
import hell.enums.HeroTypes;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.*;

public abstract class BaseHero implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected BaseHero(String name, String type, Inventory inventory) {
        this.name = name;
        this.strength = HeroTypes.valueOf(type).getStrength();
        this.agility = HeroTypes.valueOf(type).getAgility();
        this.intelligence = HeroTypes.valueOf(type).getIntelligence();
        this.hitPoints = HeroTypes.valueOf(type).getHitPoints();
        this.damage = HeroTypes.valueOf(type).getDamage();
        this.inventory = inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Item> itemList = new LinkedHashMap<>();

        Class aClass = this.inventory.getClass();

        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(ItemCollection.class)) {
                declaredField.setAccessible(true);
                itemList = (Map<String, Item>) declaredField.get(this.inventory);
            }
        }

//        without Annotation:
//        Field items = aClass.getDeclaredField("commonItems");
//        items.setAccessible(true);
//        itemList = (Map<String, Item>) items.get(this.inventory);

        return itemList.values();
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s, Class: %s", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        sb.append(String.format("HitPoints: %d, Damage: %d", this.getHitPoints(), this.getDamage()))
                .append(System.lineSeparator());
        sb.append(String.format("Strength: %d", this.getStrength()))
                .append(System.lineSeparator());
        sb.append(String.format("Agility: %d", this.getAgility()))
                .append(System.lineSeparator());
        sb.append(String.format("Intelligence: %d", this.getIntelligence()))
                .append(System.lineSeparator());
        try {
            if (this.getItems().isEmpty()) {
                sb.append("Items: None").append(System.lineSeparator());
            } else {
                sb.append("Items:").append(System.lineSeparator());
                for (Item item : this.getItems()) {
                    sb.append(item.toString());
                    sb.append(System.lineSeparator());
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return sb.toString().trim();
    }
}
