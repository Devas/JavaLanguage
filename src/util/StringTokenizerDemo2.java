package util;

import java.util.StringTokenizer;

import static javax.swing.JOptionPane.showInputDialog;

public class StringTokenizerDemo2 {

    public static void main(String[] args) {
        String txt;
        while ((txt = showInputDialog("Wpisz tekst")) != null) {
            Words words = new Words(txt);
            int n = words.getWordsCount();
            System.out.println("Liczba słów: " + n);

            System.out.println("Kolejne slowa: ");
            for (String w : words.getWords())
                System.out.println(w);

            int iw = Integer.parseInt(showInputDialog("Podaj numer słowa:"));
            System.out.println("Słowo o numerze " + iw + ": " + words.getWord(iw));
            System.out.println("Najdluższe słowo: " + words.getMaxLenWord());
            System.out.println("Najkrótsze słowo: " + words.getMinLenWord());
        }
    }
}

class Words {

    private String[] words;
    private String maxLenWord;
    private String minLenWord;

    public Words(String txt) throws IllegalArgumentException {

        if (txt == null)
            throw new IllegalArgumentException("Wadliwy argument konstruktora Words: null");

        StringTokenizer st = new StringTokenizer(txt, " \t\n\r\f.,:;()[]\"'?!-{}");

        int n = st.countTokens();
        if (n == 0)
            throw new IllegalArgumentException("Wadliwy argument konstruktora Words: napis nie zawiera słów");

        words = new String[n];
        words[0] = maxLenWord = minLenWord = st.nextToken();

        int i = 1;

        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.length() > maxLenWord.length()) {
                maxLenWord = s;
            } else if (s.length() < minLenWord.length()) {
                minLenWord = s;
            }
            words[i++] = s;
        }
    }

    public int getWordsCount() {
        return words.length;
    }

    public String getWord(int i) {
        return (i < 1 || i > words.length) ? null : words[i - 1];
    }

    public String[] getWords() {
        return words;
    }

    public String getMaxLenWord() {
        return maxLenWord;
    }

    public String getMinLenWord() {
        return minLenWord;
    }
}