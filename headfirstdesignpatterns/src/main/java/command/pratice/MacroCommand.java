package command.pratice;

import command.Command;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    List<Command> commands;
    public MacroCommand() {
        commands = new ArrayList<>();
    }

    public void add(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
