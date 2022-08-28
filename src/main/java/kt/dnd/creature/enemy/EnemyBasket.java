package kt.dnd.creature.enemy;

import kt.dnd.creature.Creature;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EnemyBasket {
    private List<Creature> enemies = new ArrayList();

    public List<Creature> list() {
        return enemies;
    }

    public void add(Creature enemy) {
        this.enemies.add(enemy);
    }

    public void remove(String name) {
        System.out.print(">> Removing enemy " + name);
        Creature enemy = findEnemy(name);
        System.out.println(enemy);
        enemies.remove(enemy);
    }

    private Creature findEnemy(String nameFilter) {
        Optional<Creature> enemy = enemies.stream().filter(x -> x.name.equals(nameFilter)).findAny();
        if (enemy.isPresent())
            return enemy.get();
        else
            throw new IllegalArgumentException("No enemy with given name!");
    }
}
