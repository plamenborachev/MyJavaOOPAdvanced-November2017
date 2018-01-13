package hell.factories;

import hell.entities.items.ItemImpl;
import hell.interfaces.Item;

public final class ItemFactory {

    private ItemFactory() {
    }

    public static Item createItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        return new ItemImpl(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }
}
