package kt.dnd.items;

public class Item {
    private String name;
    private Boolean equipped;

    public Item (String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
