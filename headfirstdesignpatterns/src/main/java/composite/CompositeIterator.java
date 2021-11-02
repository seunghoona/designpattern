package composite;


import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponet> {
    Stack<Iterator<MenuComponet>> stack = new Stack<Iterator<MenuComponet>>();

    public CompositeIterator(Iterator<MenuComponet> iterator) {
        stack.push(iterator);
    }

    public MenuComponet next() {
        if (hasNext()) {
            Iterator<MenuComponet> iterator = stack.peek();
            MenuComponet component = iterator.next();
            stack.push(component.createIterator());
            return component;
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<MenuComponet> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
