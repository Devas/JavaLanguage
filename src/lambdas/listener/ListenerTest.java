package lambdas.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerTest {

    public static void main(String[] args) {
        JButton testButton = new JButton("Invarience Button");
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Click Detected by Anon Class");
            }
        });

        testButton.addActionListener(e -> System.out.println("Click Detected by Lambda Listner"));

        // Swing stuff
        JFrame frame = new JFrame("Listener Invarience");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(testButton, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}