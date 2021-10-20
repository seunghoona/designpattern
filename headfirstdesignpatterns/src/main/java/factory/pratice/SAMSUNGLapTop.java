package factory.pratice;

public class SAMSUNGLapTop implements Computer {
    ComputerBuPoom computerBuPoom;

    public SAMSUNGLapTop(ComputerBuPoom computerBuPoom) {
        this.computerBuPoom = computerBuPoom;
    }

    @Override
    public void benefit() {
        computerBuPoom.createKeyBoard();
        computerBuPoom.createMouse();
    }
}
