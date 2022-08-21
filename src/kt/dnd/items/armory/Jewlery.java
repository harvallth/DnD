package kt.dnd.items.armory;

import kt.dnd.items.Item;

public class Jewlery extends Item {
    public Jewlery(String name) {
        super(name);
    }

    public enum Type {
        AMULET,
        BRACELET,
        NECKLACE,
        PENDANT,
        RING,
        SIGNET;
    }
}
