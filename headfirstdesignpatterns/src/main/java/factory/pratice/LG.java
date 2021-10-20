package factory.pratice;

public class LG  extends Company {

    ComputerBuPoom computerBuPoom;

    public LG(ComputerBuPoom computerBuPoom) {
        this.computerBuPoom = computerBuPoom;
    }

    @Override
    Computer createComputer(String type) {

        if(type.equals("laptop")) {
            return new LGLapTop(new LGComputerBuPoom());
        }
        throw new IllegalArgumentException();
    }
}
