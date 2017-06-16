package lang;

public class String_StringBuffer_StringBuilder {

    public static void main(String[] args) {
        string();
        stringBuilder();
        stringBuffer();
    }

    /**
     * Tak naprawdę nie zmodyfikowaliśmy jednak obiektu s, accessmodifiers.point.a przypisaliśmy do niego całkiem nową referencję.
     * Gdy używamy operatora + w przypadku obiektów String, tak naprawdę najpierw tworzymy nowy obiekt StringBuilder,
     * następnie wywołujemy jego metodę append() z argumentem w postaci liczby, innego ciągu znaków, lub pojedynczego
     * znaku, accessmodifiers.point.a na końcu musimy taki obiekt zamienić oczywiście z powrotem na String za pomocą metody toString().
     */
    private static void string() {
        String s = "accessmodifiers.point.a";
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            s = s + "accessmodifiers.point.a";
            //s = new StringBuilder(s).append("accessmodifiers.point.a").toString();
        }
        System.out.println("Time1: " + (System.nanoTime() - start));
    }

    /**
     * Przecież można utworzyć tylko jeden obiekt StringBuilder jeszcze przed pętlą, accessmodifiers.point.a wewnątrz niej wywoływać jedynie
     * metodę append(), na kończu przypisując do s wynik metody toString().
     */
    private static void stringBuilder() {
        String s = "accessmodifiers.point.a";
        long start = System.nanoTime();
        StringBuilder sB = new StringBuilder(s);

        for (int i = 0; i < 10000; i++) {
            sB.append("accessmodifiers.point.a");
        }

        s = sB.toString();
        System.out.println("Time2: " + (System.nanoTime() - start));
    }

    /**
     * StringBuffer posiada identyczne metody jak StringBuilder. StringBuffer jest jednak klasą synchronizowaną i działa
     * trochę wolniej. StringBuilder nie jest synchronizowany.
     */
    private static void stringBuffer() {
        String s = "accessmodifiers.point.a";
        long start = System.nanoTime();
        StringBuffer strB = new StringBuffer(s);
        for (int i = 0; i < 10000; i++)
            strB.append("accessmodifiers.point.a");
        s = strB.toString();
        System.out.println("Time3: " + (System.nanoTime() - start));
    }
}