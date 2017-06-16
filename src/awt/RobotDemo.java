package awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RobotDemo {

    Robot robot;

    public RobotDemo() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            System.err.println("Co ten robot wyprawia?!");
            e.printStackTrace();
        }
    }

    /**
     * Metoda drukuje tekst "Hello World"
     */
    public void printText() {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        robot.mouseMove(1599, 0);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.delay(1000);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);

        int[] text = {KeyEvent.VK_H, KeyEvent.VK_E, KeyEvent.VK_L, KeyEvent.VK_L, KeyEvent.VK_O, KeyEvent.VK_SPACE,
                KeyEvent.VK_W, KeyEvent.VK_O, KeyEvent.VK_R, KeyEvent.VK_L, KeyEvent.VK_D};

        //pętla - wciśnięcie przycisku i przerwa na 200ms
        for (int i = 0; i < text.length; i++) {
            robot.keyPress(text[i]);
            robot.delay(200);
        }
    }

    /**
     * Metoda robi screenshot ekranu i zapisuje go na dysku
     */
    public void screenCapture() {
        //pobieramy rozmiar ekranu i tworzymy Rectanglehello world
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);
        //robimy screenshot z utworzonego obszaru
        BufferedImage screen = robot.createScreenCapture(rectangle);
        try {
            ImageIO.write(screen, "jpg", new File("out/screenshot.jpg"));
        } catch (IOException e) {
            System.err.println("Błąd zapisu obrazu");
            e.printStackTrace();
        }
    }

    /**
     * Testujemy czy działa
     */
    public static void main(String[] args) {
        RobotDemo test = new RobotDemo();
        test.robot.delay(1000);
        test.printText();
        test.screenCapture();
    }

}