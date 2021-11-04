package compound;

import command.GarageDoor;

public class DuckGooseAdapter implements Quackable{
    Goose goose;

    public DuckGooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
