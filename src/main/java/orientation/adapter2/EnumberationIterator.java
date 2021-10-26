package orientation.adapter2;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumberationIterator<E> implements Iterator<E> {

    Enumeration<E> enumberation;

    public EnumberationIterator(Enumeration enumberation) {
        this.enumberation = enumberation;
    }

    @Override
    public boolean hasNext() {
        return enumberation.hasMoreElements();
    }

    @Override
    public E next() {
        return enumberation.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
