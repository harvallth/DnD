package kt.dnd.commands;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    private List<Command> children = new ArrayList();
    private List<Command> parents = new ArrayList();

    protected List<Command> getChildren() {
        return children;
    };
    protected List<Command> getParents() {
        return parents;
    };

    public void addChild(Command child) {
        this.children.add(child);
    }

    public void addParent(Command parent) {
        this.parents.add(parent);
    };

    public abstract void showHelp();
    public void execute() {
        List<Command> subcommands = this.getChildren();
        if (subcommands.isEmpty())
            showHelp();
        else
            subcommands.get(0).execute();
    }
}
