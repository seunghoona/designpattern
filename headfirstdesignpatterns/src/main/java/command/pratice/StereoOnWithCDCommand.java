package command.pratice;

import command.Command;

public class StereoOnWithCDCommand implements Command {
    StereoOnWithCD stereoOnWithCD;

    public StereoOnWithCDCommand(StereoOnWithCD stereoOnWithCD) {
        this.stereoOnWithCD = stereoOnWithCD;
    }

    @Override
    public void execute() {
        stereoOnWithCD.on();
        stereoOnWithCD.inputCD();
        stereoOnWithCD.play();
    }
}
