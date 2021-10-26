package command;

public class GarageDorrOpenCommand implements Command{
    GarageDoor garageDoor;

    public GarageDorrOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }
}
