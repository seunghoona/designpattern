package factory.pratice;

public abstract class Company {

    public Computer orderComputer(String type) {
        Computer computer = createComputer(type);
        computer.benefit();
        return computer;
    };

    abstract Computer createComputer(String type);
}
