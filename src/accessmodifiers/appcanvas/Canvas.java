package accessmodifiers.appcanvas;

class Canvas {

    static void getArea() {
        CirclePlus circle = new CirclePlus();
//        System.out.println(circle.color); // protected field cannot be accessed in: Other class outside the package
//        System.out.println(circle.hue); // package-protected field cannot be accessed in: Other class outside the package
        circle.area(); // call to public method area(), outside package
//        circle.fillColor(); // not public and cannot be accessed
//        Printable p = new Printable() {
//            @Override
//            public void print() {
//
//            }
//
//            @Override
//            public void printRich() {
//
//            }
//        }; // cannot access package-protected interface in outside package
//        p.print();
    }

    public static void main(String[] args) {
        getArea();
    }
}