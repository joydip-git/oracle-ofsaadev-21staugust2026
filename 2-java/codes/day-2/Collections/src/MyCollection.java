//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class MyCollection<E> implements Iterable<E> {
    private E[] elements;
    int index;

    @SuppressWarnings("unchecked")
    public MyCollection() {
        elements = (E[]) new Object[4];
    }

    public void add(E element) {
        if (index == elements.length) {
            System.out.println("here....");
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[index] = element;
        index++;
    }

    public int capacity() {
        return elements.length;
    }

    public int size() {
        return index;
    }

    @Override
    public Iterator<E> iterator() {
        return new CollectionIterator<>();
    }

    private class CollectionIterator<T> implements Iterator<T> {

        int cursor = -1;

        @Override
        public boolean hasNext() {
            return cursor < index - 1;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            cursor++;
            return (T) elements[cursor];
        }
    }
}
