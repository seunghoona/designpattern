package factory.pratice;

public class LGComputerBuPoom implements ComputerBuPoom {
    @Override
    public Mouse createMouse() {
        return new LogitecMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new LogitecKeyBoard();
    }
}
