package accessmodifiers.graphicshape;

class Circles {

    static void getArea() {
        Circle circle = new Circle();
        System.out.println(circle.color); // protected field accessed in: Other class inside the package
        System.out.println(circle.hue);   // package-protected field accessed in: Other class inside the package
        circle.area(); // call to public method area() within package
        circle.fillColor(); // call to accessmodifiers.point.a method with default access modifier within package
        Printable p;
    }

    public static void main(String[] args) {
        getArea();
    }
}