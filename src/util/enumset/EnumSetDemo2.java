package util.enumset;

import java.util.EnumSet;

public class EnumSetDemo2 {

    private enum FontStyle { Bold, Italic, Underline, Strikethrough }

    public static void main(String args[]) {
        EnumSet<FontStyle> currentStyle = EnumSet.of(FontStyle.Bold, FontStyle.Italic);
        if (currentStyle.contains(FontStyle.Bold)) {
            System.out.println("Bold");
        }
        if (currentStyle.contains(FontStyle.Italic)) {
            System.out.println("Italic");
        }
        if (currentStyle.contains(FontStyle.Underline)) {
            System.out.println("Underline");
        }
        if (currentStyle.contains(FontStyle.Strikethrough)) {
            System.out.println("Strikethrough");
        }
    }

}