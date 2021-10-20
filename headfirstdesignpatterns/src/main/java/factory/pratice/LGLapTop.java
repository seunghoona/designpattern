package factory.pratice;

public class LGLapTop implements Computer {
    ComputerBuPoom computerBuPoom;

    public LGLapTop(ComputerBuPoom computerBuPoom) {
        System.out.println("랩탑생성");
        this.computerBuPoom = computerBuPoom;
    }

    @Override
    public void benefit() {
        computerBuPoom.createKeyBoard();
        computerBuPoom.createMouse();
    }
}
