package kt.dnd.items;

public class Gold extends Item {
    private Integer value = 0;

    public Gold(int value) {
        super("GOLD");
        this.value = value;
    }

    public static Gold of(int value) {
        return new Gold(value);
    }

    @Override
    public String toString() {
        return "GOLD: " + value;
    }
}
