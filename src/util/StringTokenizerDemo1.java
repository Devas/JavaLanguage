package util;

import java.util.StringTokenizer;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class StringTokenizerDemo1 {

    public static void main(String[] args) {

        String normalQuest = "Liczba1 Operator Liczba2";
        String errorQuest = "Wadliwe dane. Popraw.\n" + normalQuest;
        String quest = normalQuest;
        String expr = "";

        while ((expr = showInputDialog(quest, expr)) != null) {
            int res;
            try {
                StringTokenizer st = new StringTokenizer(expr);
                int num1 = Integer.parseInt(st.nextToken());
                String sop = st.nextToken();
                int num2 = Integer.parseInt(st.nextToken());

                if (sop.length() != 1 || st.hasMoreTokens())
                    throw new IllegalArgumentException();

                switch (sop.charAt(0)) {
                    case '+':
                        res = num1 + num2;
                        break;
                    case '-':
                        res = num1 - num2;
                        break;
                    case '*':
                        res = num1 * num2;
                        break;
                    case '/':
                        res = num1 / num2;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (Exception exc) {
                quest = errorQuest;
                continue;
            }

            showMessageDialog(null, "Wynik = " + res);
            quest = normalQuest;
            expr = "";
        }
    }
}