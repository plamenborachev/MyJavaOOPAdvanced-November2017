package hell;

import hell.entities.heros.Assassin;
import hell.entities.heros.Barbarian;
import hell.entities.heros.Wizard;
import hell.entities.items.ItemImpl;
import hell.entities.items.RecipeImpl;
import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.*;
import hell.io.Reader;
import hell.io.Writer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        InputReader reader = new Reader();
        OutputWriter writer = new Writer();

        String[] commandTokens = reader.readLine().split("\\s+");

        Map<String, Hero> heroes = new LinkedHashMap<>();

        while (!"Quit".equals(commandTokens[0])) {
            switch (commandTokens[0]) {
                case "Hero":
                    String heroName = commandTokens[1];
                    String heroType = commandTokens[2];
                    Hero hero = null;
                    Inventory inventory = new HeroInventory();
                    switch (heroType) {
                        case "Barbarian":
                            hero = new Barbarian(heroName, heroType.toUpperCase(), inventory);
                            break;
                        case "Assassin":
                            hero = new Assassin(heroName, heroType.toUpperCase(), inventory);
                            break;
                        case "Wizard":
                            hero = new Wizard(heroName, heroType.toUpperCase(), inventory);
                            break;
                    }
                    heroes.putIfAbsent(heroName, hero);
                    writer.writeLine(String.format("Created %s - %s", heroType, heroName));
                    break;
                case "Item":
                    String itemName = commandTokens[1];
                    heroName = commandTokens[2];
                    int strengthBonus = Integer.parseInt(commandTokens[3]);
                    int agilityBonus = Integer.parseInt(commandTokens[4]);
                    int intelligenceBonus = Integer.parseInt(commandTokens[5]);
                    int hitpointsBonus = Integer.parseInt(commandTokens[6]);
                    int damageBonus = Integer.parseInt(commandTokens[7]);
                    Item item = new ItemImpl(itemName, strengthBonus, agilityBonus, intelligenceBonus,
                            hitpointsBonus, damageBonus);
                    heroes.get(heroName).addItem(item);
                    writer.writeLine(String.format("Added item - %s to Hero - %s", itemName, heroName));
                    break;
                case "Recipe":
                    String recipeName = commandTokens[1];
                    heroName = commandTokens[2];
                    strengthBonus = Integer.parseInt(commandTokens[3]);
                    agilityBonus = Integer.parseInt(commandTokens[4]);
                    intelligenceBonus = Integer.parseInt(commandTokens[5]);
                    hitpointsBonus = Integer.parseInt(commandTokens[6]);
                    damageBonus = Integer.parseInt(commandTokens[7]);
                    Recipe recipe = new RecipeImpl(recipeName, strengthBonus, agilityBonus, intelligenceBonus,
                            hitpointsBonus, damageBonus, Arrays.stream(commandTokens).skip(8L).toArray(String[]::new));
                    heroes.get(heroName).addRecipe(recipe);
                    writer.writeLine(String.format("Added recipe - %s to Hero - %s", recipeName, heroName));
                    break;
                case "Inspect":
                    heroName = commandTokens[1];
                    writer.writeLine(heroes.get(heroName).toString());
                    break;
            }
            commandTokens = reader.readLine().split("\\s+");
        }

        List<Hero> sortedHeroes = heroes.values().stream()
                .sorted((h1, h2) -> {
                    if ((h2.getStrength() + h2.getAgility() + h2.getIntelligence()) ==
                            h1.getStrength() + h1.getAgility() + h1.getIntelligence()){
                        return Long.compare((h2.getHitPoints() + h2.getDamage()),
                                (h1.getHitPoints() + h1.getDamage()));
                    } else {
                        return Long.compare((h2.getStrength() + h2.getAgility() + h2.getIntelligence()),
                                h1.getStrength() + h1.getAgility() + h1.getIntelligence());
                    }
                })
                .collect(Collectors.toList());

        int counter = 1;
        StringBuilder sb = new StringBuilder();
        for (Hero hero : sortedHeroes) {
            sb.append(String.format("%d. %s: %s",
                    counter++, hero.getClass().getSimpleName(), hero.getName()))
                    .append(System.lineSeparator());
            sb.append(String.format("###HitPoints: %d",
                    hero.getHitPoints()))
                    .append(System.lineSeparator());
            sb.append(String.format("###Damage: %d",
                    hero.getDamage()))
                    .append(System.lineSeparator());
            sb.append(String.format("###Strength: %d",
                    hero.getStrength()))
                    .append(System.lineSeparator());
            sb.append(String.format("###Agility: %d",
                    hero.getAgility()))
                    .append(System.lineSeparator());
            sb.append(String.format("###Intelligence: %d",
                    hero.getIntelligence()))
                    .append(System.lineSeparator());
            if (hero.getItems().isEmpty()) {
                sb.append("###Items: None").append(System.lineSeparator());
            } else {
                sb.append("###Items: ");
                List<String> items = hero.getItems().stream().map(Item::getName).collect(Collectors.toList());
                sb.append(String.join(", ", items));
                sb.append(System.lineSeparator());
            }
        }
        writer.writeLine(sb.toString());
    }
}