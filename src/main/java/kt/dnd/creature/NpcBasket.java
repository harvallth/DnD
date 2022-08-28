package kt.dnd.creature;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class NpcBasket {
    private List<Npc> npcList = new ArrayList();

    public List<Npc> list() {
        System.out.println(">> List all generated NPCs:");
        System.out.println(npcList.toString());
        return npcList;
    }

    public void add(Npc npc) {
        this.npcList.add(npc);
    }

    public void remove(String nameFilter) {
        System.out.print(">> Removing NPC " + nameFilter);
        Npc npc = findNpc(nameFilter);
        System.out.println(npc);
        npcList.remove(npc);
    }

    private Npc findNpc(String nameFilter) {
        Optional<Npc> npcToBeRemoved = npcList.stream().filter(x -> x.name.equals(nameFilter)).findAny();
        if (npcToBeRemoved.isPresent())
            return npcToBeRemoved.get();
        else
            throw new IllegalArgumentException("No NPC with given name!");
    }
}
