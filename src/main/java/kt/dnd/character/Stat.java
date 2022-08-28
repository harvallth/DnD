package kt.dnd.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stat {
    public Stat(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    public static List<Stat> of(int str, int dex, int con, int wis, int per, int cha) {
        List<Stat> stats = new ArrayList<>();
        stats.add(new Stat(str));
        stats.add(new Stat(dex));
        stats.add(new Stat(con));
        stats.add(new Stat(wis));
        stats.add(new Stat(per));
        stats.add(new Stat(cha));
        return stats;
    }

    public static List<Stat> random() {
        List<Stat> stats = new ArrayList<>();
        Random randomizer = new Random();

        stats.add(new Stat(1 + randomizer.nextInt(10)));
        stats.add(new Stat(1 + randomizer.nextInt(10)));
        stats.add(new Stat(1 + randomizer.nextInt(10)));
        stats.add(new Stat(1 + randomizer.nextInt(10)));
        stats.add(new Stat(1 + randomizer.nextInt(10)));
        stats.add(new Stat(1 + randomizer.nextInt(10)));
        stats.add(new Stat(1 + randomizer.nextInt(10)));
        stats.add(new Stat(1 + randomizer.nextInt(10)));
        stats.add(new Stat(1 + randomizer.nextInt(10)));

        return stats;
    }
}
