package kt.dnd.actions;

import kt.dnd.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Looting {

    public static List<Item> generateRandomLoot() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Brewiarz"));
        items.add(new Item("Lanca"));
        return items;
    }
}
