package factory.pratice;

public class SAMSUNG extends Company {
    @Override
    Computer createComputer(String type) {
        return new SAMSUNGLapTop(new LGComputerBuPoom());
    }
}
