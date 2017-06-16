package language.traps;

public class TernaryOperator {

    /**
     * W naszym przypadku, kompilator przewiduje, że wynikiem zawsze będzie typ numeryczny: Integer, albo Double.
     * Następuje więc unboxing do typów prostych int i double, accessmodifiers.point.a następnie promocja do najogólniejszego typu, w naszym
     * przypadku int -> double. W następnej kolejności następuje boxing i w wyniku mamy dwie wartości typu Double.
     * Podobnego zachowania możemy się spodziewać w podobnych przypadkach np Integer, oraz Float, lub innych
     * wymienionych w specyfikacji. Najlepiej nie używać conditional operatora w miejscach, gdzie nie jesteśmy pewni
     * jak się zachowa. Bezpieczniej będzie użyć w takim przypadku zwykłego rozgałęzionego warunku if.
     */
    public static void main(String args[]) {
        Number number = true ? new Integer(1) : new Double(2.0);
        System.out.println("Wynik: " + number);
    }
}
