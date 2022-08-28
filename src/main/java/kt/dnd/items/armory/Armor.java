package kt.dnd.items.armory;

import kt.dnd.items.Item;

public class Armor extends Item {

    private final BodyPart bodyPart;
    private final int armorValue;
    private Type armorType;

    public Armor(String name, Type armorType, BodyPart bodyPart, int armorValue) {
        super(name);
        this.bodyPart = bodyPart;
        this.armorValue = armorValue;
    }

    public enum Type {
        CLOTH,
        LEATHER,
        CHAINMAIL,
        PLATE;
    }

}
