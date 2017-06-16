package collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Index accessmodifiers.point.a list of keywords (like books)
 */
public class TreeMapDemo {

    private static List<String> languages = Arrays.asList("C#", "Java", "C++", "Python", "Groovy", "Ruby", "C", "Lua",
            "Go", "Lisp", "Erlang", "Javascript", "Pascal", "Go", "Scala");

    private static Map<Character, List<String>> index(List<String> keywords) {
        Map<Character, List<String>> dictionary = new TreeMap<>(Comparator.reverseOrder());
        for (String keyword : keywords) {
            char firstChar = keyword.charAt(0);
            if (!dictionary.containsKey(firstChar)) {
                dictionary.put(firstChar, new ArrayList<>());
            }
            dictionary.get(firstChar).add(keyword);
        }
        for (List<String> stringList : dictionary.values()) {
            Collections.sort(stringList);
        }
        return dictionary;
    }

    private static Map<Character, List<String>> indexWithStream(List<String> keywords) {
        return keywords.stream().collect(Collectors.groupingBy(k -> k.charAt(0)));
    }

    public static void main(String[] args) {
        for (Map.Entry<Character, List<String>> entry : index(languages).entrySet()) {
            System.out.println(entry);
        }
        System.out.println();
        for (Map.Entry<Character, List<String>> entry : indexWithStream(languages).entrySet()) {
            System.out.println(entry);
        }
    }

}
