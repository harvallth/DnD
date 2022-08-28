package kt.dnd.commands;

import org.springframework.stereotype.Component;

import java.util.List;

public class RootCommand extends Command {

    private List<String> params;
    private String value;

    RootCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RootCommand of(String value) {
        for(String v : values())
            if(v.equalsIgnoreCase(value))
                return new RootCommand(v);
        throw new IllegalArgumentException();
    }

    private static String[] values() {
        return new String[]{"HELP", "BREAK", "PLAYER", "NPC", "ENEMY", "LOOT", "COMBAT" };
    }

    public void attachParams(List<String> params) {
        this.params = params;
    }

    public List<String> getParams() {
        return params;
    }

    @Override
    public void showHelp() {
        System.out.println(">> List of commands:");
        System.out.println("\tBREAK\t- Finish the game.");
        System.out.println("\tPLAYER\t- Shows a list of all players with stats.");
        System.out.println("\tNPC\t\t- Modify or generate random NPC.");
        System.out.println("\tENEMY\t- Modify or generate random enemy.");
        System.out.println("\tLOOT\t- Generate random loot.");
        System.out.println("\tCOMBAT\t- Handle combat.");
    }
}
