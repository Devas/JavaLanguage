package collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {

    public static void main(String[] args) {
        Map<String, Integer> mapa;
        mapa = new HashMap<String, Integer>();
        mapa = new TreeMap<String, Integer>();
        mapa = new IdentityHashMap<>();
        mapa = new LinkedHashMap<>();
        mapa = new WeakHashMap<>();
        mapa = new ConcurrentHashMap<>();
        mapa.put("pierwszy", 1);
        mapa.put("drugi", 2);
        System.out.println(mapa.get("pierwszy"));
    }

}
