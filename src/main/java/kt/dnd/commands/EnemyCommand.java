package kt.dnd.commands;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EnemyCommand extends Command {

    @Override
    public void execute() {
        System.out.println(">> ENEMY command NYI");// TODO: ENEMY(stats) delegates creature creation
        showHelp();
    }

    @Override
    public void showHelp() {
        System.out.println(">> List of ENEMY subcommands:");
        System.out.println("\tENEMY LIST\t\t\t- Shows a list of all enemies for current encounter.");
        System.out.println("\tENEMY CREATE\t\t- Generates enemies from the basket");
        System.out.println("\tENEMY KILL <name>\t- Kills an enemy <name>");
        System.out.println("\tENEMY MOD <name>\t- Modifies stats of an enemy <name>");
    }
}
