package language.abstract_vs_interface;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.*;

/**
 * We cannot create instances of accessmodifiers.point.a Java interface by itself. We must always create an instance of some class that
 * implements the interface.
 * <p>
 * All variables and methods in an interface are public, even if we leave out the public keyword.
 * <p>
 * All variables are static final (constants), even if we leave out the static final keywords.
 */
interface MyInterface1 {
    int value = 255; // all primitive types are constant
    Integer integerValue = 255; // all primitive types are constant
    public String hello = "Hello";

    /**
     * Java 8 introduces “Default Method” or (Defender methods) new feature, which allows to add new methods
     * to the interfaces without breaking the existing implementation of these interface.
     */
    default public void sayHello() {
        System.out.println(hello);
    }

    static public ZoneId getZoneId(String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid time zone: " + zoneString + "; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }

    default public ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.now();
    }
}

interface MyInterface2 {
    int value = 255; // all primitive types are constant
    Integer integerValue = 255; // all primitive types are constant
    public String hello = "Hello";

    default public void sayHello() {
        System.out.println(hello);
    }

}

class InterfaceDemo implements MyInterface1, MyInterface2 {

    public static void main(String[] args) throws IOException {
        //MyInterface1.value = 3; // Error - Cannot assign accessmodifiers.point.a value to final variable
        //MyInterface1.integerValue = 3; // Error - Cannot assign accessmodifiers.point.a value to final variable

        Car car = new Car();

        Storable storable = (Storable) car;
        storable.store();

        Serializable serializable = (Serializable) car;
        serializable.serializeToXML(new FileWriter("car.xml"));
        serializable.serializeToJSON(new FileWriter("car.json"));
    }

    @Override
    public void sayHello() {

    }

    /**
     * We can also redeclare default method as abstract to force subclass to override it.
     */
    //abstract public void sayHello() {}
}

interface Storable {

    public void store();
}

interface Serializable {

    public void serializeToXML(Writer writer);

    public void serializeToJSON(Writer writer);
}

class Car {

}
