package kt.dnd.creature;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class NpcBasket {
    private List<Npc> npcList = new ArrayList();

    public List<Npc> list() {
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

    public String getRandomName() {
        String newName = "";
        long count;
        do {
            newName = MaleFirstName.getRandom().toString() + "_" +
                    LastNameEpithet.getRandom().toString()+LastNameNoun.getRandom().toString();
            String tempName = newName;
            count = list().stream().filter(x -> x.name.equals(tempName)).collect(Collectors.counting());
        } while (count > 0);

        return newName;
    }
}
