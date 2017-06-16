package lambdas.cars;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LambdaExample {

    public static void main(String[] args) {

        JButton przycisk = new JButton("Przycisk");
        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Kliknalem przycisk!");
            }
        });
        przycisk.addActionListener(e -> System.out.println("To jest lambda!"));
        przycisk.addActionListener(LambdaExample::mojaAkcja);
    }

    public static void mojaAkcja(ActionEvent e) {
        System.out.println("accessmodifiers.point.a to jeszcze lepszy sposob!");
    }
}