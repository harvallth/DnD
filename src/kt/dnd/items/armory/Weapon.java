package kt.dnd.items.armory;

import kt.dnd.items.Item;

public class Weapon extends Item {

    private final String damage;

    public Weapon(String name, String damage) {
        super(name);
        this.damage = damage;
    }
}
