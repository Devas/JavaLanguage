package language.traps;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class URL_URI_ {

    /**
     * Metoda equals() traktuje dwa obiekty URL za równe, jeśli ich adres sieciowy się zgadza. Ponieważ dwie pierwsze
     * strony posiadają taki sam adres IP serwera, to są przez metodą equals() traktowane jako równe obiekty, więc
     * w wyniku otrzymamy Size: 3. Jeśli odłączymy się od internetu otrzymamy Size: 4 - nie zostanie porównany adres IP.
     *
     * We should use URI class which behaves properly. It also contains toURL() method.
     */
    public static void main(String[] args) {
        URLmethod();
        URImethod();
    }

    public static void URLmethod() {
        Set set = new HashSet();
        try {
            set.add(new URL("http://bbc.com"));
            set.add(new URL("http://bbc.co.uk"));
            set.add(new URL("http://editor.javastart.pl"));
            set.add(new URL("http://google.pl"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("URL Size: " + set.size());
    }

    public static void URImethod() {
        Set set = new HashSet();
        try {
            set.add(new URI("http://max3d.pl"));
            set.add(new URI("http://computerrenovations.com"));
            set.add(new URI("http://editor.javastart.pl"));
            set.add(new URI("http://google.pl"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println("URI Size: " + set.size());
    }
}