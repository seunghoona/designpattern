package composite;

import java.util.Iterator;

public class NullIterator implements Iterator<MenuComponet> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponet next() {
        return null;
    }
}
