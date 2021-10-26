package command.pratice;

import command.Command;
import command.GarageDoor;

public class GarageDorrCloseCommand implements Command {
    GarageDoor garageDoor;

    public GarageDorrCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }
}
