package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lists {
    public static void main(String[] args) {
        List<String> lista;
        lista = new ArrayList<String>();
        lista = new LinkedList<String>();
        lista = new Vector<String>();
        lista = new CopyOnWriteArrayList<>();
        lista.add("pierwszy");
        lista.add("drugi");
        System.out.println(lista.get(1));
    }
}
