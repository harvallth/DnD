package kt.dnd.commands;

public class HelpCommand extends Command {

    @Override
    public void execute() {
        RootCommand rootCommand = (RootCommand) getParents().get(0);

        if (rootCommand.getChildren().isEmpty())
            showHelp();
        else
            rootCommand.getChildren().get(0).showHelp();
    }

    @Override
    public void showHelp() {
        System.out.println(">> List of commands:");
        System.out.println("\tBREAK\t- Finish the game.");
        System.out.println("\tPLAYER\t- Shows a list of all players with stats.");
        System.out.println("\tNPC\t\t- Modify or generate random NPC."); // TODO: NPC just help screen -> NPC NEW generates new NPC
        System.out.println("\tENEMY\t- Modify or generate random enemy."); // TODO: as above + ENEMY(stats) delegates creature creation
        System.out.println("\tLOOT\t- Generate random loot."); // TODO: as above +
    }
}
