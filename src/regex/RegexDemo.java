package regex;

public class RegexDemo {

    public static void main(String[] args) {

    }

    // PL25 1212 2323 4545 5656 7878 8989
    public static boolean checkIbanFormat(String number) {
        // "PL\\d{2}( \\d{4}){6}"
        return number.matches("PL[0-9]{2}( [0-9]{4}){6}");
    }

    public static boolean checkIpFormat(String ip) {
        return ip.matches("([0-9]{1,3}\\.){3}[0-9]{1,3}");
    }

    /**
     * To check backslash in regex we have to use 4 backslashes
     * http://stackoverflow.com/questions/4025482/cant-escape-the-backslash-with-regex
     *
     * @param path
     * @return
     */
    public static boolean checkPathFormat(String path) {
        return path.matches("([A-Z]:\\\\)?(\\w+\\\\)+(\\w+.\\w+)?");
    }
}
