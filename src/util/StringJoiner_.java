package util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoiner_ {

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        try {
            ex4();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * StringJoiner uses internally StringBuilder
     *
     * @since 1.8
     */
    private static void ex1() {
        StringJoiner joiner = new StringJoiner(",", "{", "}");
        String result = joiner.add("Ania").add("ma").add("kota").toString();
        System.out.println(result);
    }

    /**
     * join() uses internally StringJoiner which uses StringBuilder
     *
     * @since 1.8
     */
    private static void ex2() {
        List<String> names = Arrays.asList("Ania", "Karol", "Bartek", "Jerzy");
        String allNames = "";
        allNames = allNames.join(", ", names);
        System.out.println(allNames);
    }

    /**
     * Możemy z naszej listy wyciągnąć strumień, accessmodifiers.point.a następnie wykorzystać metodę collect() do złączenia napisów.
     * Oczekuje ona jako argumentu obiektu zgodnego z interfejsem Collector.
     * Nie musimy go tworzyć sami, zamiast tego możemy skorzystać z metody Collectors.joining(),
     * która zwraca odpowiedni reduktor wykorzystujący pod spodem klasę StringJoiner.
     */
    private static void ex3() {
        List<String> names = Arrays.asList("Ania", "Karol", "Bartek", "Jerzy");
        String allNames = names.stream().collect(Collectors.joining(", ", "{", "}"));
        System.out.println(allNames);
    }

    private static void ex4() throws IOException, URISyntaxException {
        Path path = Paths.get("res/names.txt").toAbsolutePath();
        System.out.println(path);
        String collect = Files.lines(path)
                .filter(str -> str.length() > 3)
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(collect);
    }
}