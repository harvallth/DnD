package kt.dnd.commands;

import kt.dnd.creature.Npc;
import kt.dnd.creature.NpcBasket;

import java.util.List;

public class NpcCommand extends Command {

//    @Inject TODO
    private NpcBasket npcBasket = new NpcBasket();

    @Override
    public void execute() {
        RootCommand rootCommand = (RootCommand) getParents().get(0);

        if (rootCommand.getParams().isEmpty())
            showHelp();
        else switch (rootCommand.getParams().get(0)) {
            case "SHOW":
            case "LIST":
                npcBasket.list();
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
            name = Npc.getRandomName();

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
