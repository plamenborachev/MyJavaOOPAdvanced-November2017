package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecipeImpl extends BaseItem implements Recipe{

    private List<String> requiredItems;

    public RecipeImpl(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, String... requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = Arrays.asList(requiredItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return Collections.unmodifiableList(this.requiredItems);
    }
}
