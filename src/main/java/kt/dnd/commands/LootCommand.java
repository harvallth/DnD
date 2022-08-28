package kt.dnd.commands;

import kt.dnd.actions.Looting;
import kt.dnd.items.Item;

import java.util.List;

public class LootCommand extends Command {

    @Override
    public void execute() {
        RootCommand rootCommand = (RootCommand) getParents().get(0);

        String goldAmount;
        if (rootCommand.getParams().isEmpty())
            goldAmount = "20";
        else
            goldAmount = rootCommand.getParams().get(0);

        List<Item> items = Looting.generateRandomLoot();

        System.out.println(">> generated LOOT:");
        System.out.println("\tGOLD\t-\t" + goldAmount);
        System.out.println("\tITEMS\t");
        for (Item item : items) {
            System.out.println("\t\t" + item.toString());
        }
    }

    @Override
    public void showHelp() {
        System.out.println(">> LOOT command generates random items and gold.");
        System.out.println(">> LOOT <int> allows to specify gold amount.");
    }
}
