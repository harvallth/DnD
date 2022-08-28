package kt.dnd.commands;

import kt.dnd.creature.enemy.EnemyBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CombatCommand extends Command {

    @Autowired
    private EnemyBasket enemies;

    @Override
    public void execute() {
        RootCommand rootCommand = (RootCommand) getParents().get(0);

        if (rootCommand.getParams().isEmpty())
            showHelp();
        else switch (rootCommand.getParams().get(0)) {
            case "NEW":
                System.out.println(">> New combat");
                break;
            case "END":
                System.out.println(">> Finish combat");
                break;
            case "STAT":
            case "STATS":
                System.out.println(">> Combat stats");
                break;
            case "ATT":
            case "ATTACK":
                System.out.println(">> Attack");
                break;
            case "KILL":
            case "REMOVE":
                killEnemy(rootCommand.getParams());
                break;
            default:
                System.out.println(">> Bad subcommand!");
                showHelp();
                break;
        }

    }

    private void killEnemy(List<String> params) {
        String name;
        if (params.size() > 1)
            name = params.get(1);
        else
            throw new IllegalArgumentException("Missing enemy name");

        // TODO: set HP to 0, clear after fight
    }

    private void killPlayer(List<String> params) {
        String name;
        if (params.size() > 1)
            name = params.get(1);
        else
            throw new IllegalArgumentException("Missing player name");
    }

    @Override
    public void showHelp() {
        System.out.println(">> List of COMBAT subcommands:");
        System.out.println("\tCOMBAT NEW\t\t\t- Enters combat state with enemies from the 'basket'.");
        System.out.println("\tCOMBAT STATS\t\t- Shows players and enemies with HP remaining, hit chances, etc");
        System.out.println("\tCOMBAT ATTACK [NAME] - Shows required action sequence, hp remaining, hit chances, etc");
        System.out.println("\tCOMBAT KILL [NAME]\t- Kills a player, npc or enemy");
        System.out.println("\tCOMBAT END\t\t\t- Finishes combat state.");
    }
}
