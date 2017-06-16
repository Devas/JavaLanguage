package accessmodifiers.appcanvas;

import accessmodifiers.graphicshape.Shape;

public class CirclePlus extends Shape {

    private int radius = 1; // private field

    public void area() { // public method
// access to private field radius inside the class
        System.out.println("area:" + 3.14 * radius * radius);

    }

    void fillColor() {
        System.out.println("color:" + color); //access to protected field, in subclass
//        System.out.println("hue:" + hue); //access to default/package-protected field, in subclass in another package it is not allowed!
    }
}