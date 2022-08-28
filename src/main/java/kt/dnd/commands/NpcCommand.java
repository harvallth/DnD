package kt.dnd.commands;

import kt.dnd.creature.Npc;
import kt.dnd.creature.NpcBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class NpcCommand extends Command {

    @Autowired
    private NpcBasket npcBasket;

    @Override
    public void execute() {
        RootCommand rootCommand = (RootCommand) getParents().get(0);

        if (rootCommand.getParams().isEmpty())
            showHelp();
        else switch (rootCommand.getParams().get(0)) {
            case "SHOW":
            case "LIST":
                System.out.println(">> List all generated NPCs:");
                npcBasket.list().forEach(System.out::println);
                break;
            case "CREATE":
            case "ADD":
            case "NEW":
                createNpc(rootCommand.getParams());
                break;
            case "KILL":
            case "REMOVE":
                killNpc(rootCommand.getParams());
                break;
            default:
                System.out.println(">> Bad subcommand!");
                showHelp();
                break;
        }

    }

    private void createNpc(List<String> params) {
        String name;
        if (params.size() > 1)
            name = params.get(1);
        else
            name = npcBasket.getRandomName();

        System.out.print(">> ");
        npcBasket.add(new Npc(name, true));
    }

    private void killNpc(List<String> params) {
        String name;
        if (params.size() > 1)
            name = params.get(1);
        else
            throw new IllegalArgumentException("Missing NPC name");

        npcBasket.remove(name);
    }

    @Override
    public void showHelp() {
        System.out.println(">> List of NPC subcommands:");
        System.out.println("\tNPC LIST\t\t\t- Shows a list of generated NPCs.");
        System.out.println("\tNPC CREATE [NAME]\t- Generates random NPC, name might be specified.");
        System.out.println("\tNPC KILL <name>\t\t- Kills selected NPC.");
    }
}
