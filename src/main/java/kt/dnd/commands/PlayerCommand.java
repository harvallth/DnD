package kt.dnd.commands;

import org.springframework.stereotype.Component;

@Component
public class PlayerCommand extends Command {

//    @Override
//    public void execute() {
//        List<Command> subcommands = this.getChildren();
//        if (subcommands.isEmpty())
//            showHelp();
//        else
//            subcommands.get(0).execute();
//    }

    @Override
    public void showHelp() {
        System.out.println(">> List of PLAYER subcommands:");
        System.out.println("\tPLAYER LIST\t\t\t- Shows a list of all players with stats.");
        System.out.println("\tPLAYER KILL <name>\t- Kills a player <name>");
        System.out.println("\tPLAYER MOD <name>\t- Modifies stats of a player <name>");
    }
}
