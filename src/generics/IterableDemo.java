package generics;

import java.util.Iterator;

class MyCollection<E> implements Iterable<E>{

    // if we implement Iterable, we must implement iterator()
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }
}

class MyIterator <T> implements Iterator<T> {

    public boolean hasNext() {

        //implement...
        return true;
    }

    public T next() {
        //implement...;
        return null;
    }

    public void remove() {
        //implement... if supported.
    }
}

public class IterableDemo {

    public static void main(String[] args) {
        MyCollection<String> stringCollection = new MyCollection<String>();

        for(String string : stringCollection){

        }
    }
}
