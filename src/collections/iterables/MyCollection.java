package collections.iterables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyCollection<E> implements Iterable<E> {

    private List<E> list;
    private static int pointer = 0;

    public MyCollection(List list) {
        this.list = list;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    public class MyIterator<T> implements Iterator<T> {

        @Override
        public boolean hasNext() {
            if (pointer < list.size()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public T next() {
            if(this.hasNext()) {
                return (T) list.get(pointer++);
            } else {
                pointer = 0;
                return null;
            }
        }
    }
}
