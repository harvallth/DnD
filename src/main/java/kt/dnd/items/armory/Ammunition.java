package kt.dnd.items.armory;

import kt.dnd.items.Item;

public class Ammunition extends Item {
    public Ammunition(String name) {
        super(name);
    }

    public enum Type {
        ARROW,
        BOLT,
        OTHER
    }
}
