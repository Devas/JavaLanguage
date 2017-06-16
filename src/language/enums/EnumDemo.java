package language.enums;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Java enums extend the java.lang.Enum class implicitly, so enum types cannot extend another class.
 * Enum can only implement interface.
 * If enum contains fields or methods, their definition must always come after the list of constants in the enum.
 * Additionally, the list of enum constants must be terminated by accessmodifiers.point.a semicolon; in this case.
 */
enum Level {
    HIGH(3, new ArrayList<>()),    // calls constructor with value 3
    MEDIUM(2, new ArrayList<>()),  // calls constructor with value 2
    LOW(1, new LinkedList<>()),    // calls constructor with value 1
    NONE,                          // use no argument constructor
    NOTHING()                      // use no argument constructor
    ; // semicolon needed when fields / methods follow

    private final int levelCode;
    private List<String> names; // Enum can have also instance variables

    private Level(int levelCode, List<String> list) { // Constructor must be either private or package scope (default)
        this.levelCode = levelCode;
        this.names = list;
    }

    private Level() {
        this.levelCode = 0;
        this.names = new ArrayList<>();
    }

    public int getLevelCode() {
        return this.levelCode;
    }

    public List<String> getNames() {
        return this.names;
    }

    public void addName(String name) {
        this.names.add(name);
    }
}

public class EnumDemo {

    public static void main(String[] args) {
        System.out.println(Level.HIGH.name());
        System.out.println(Level.HIGH.toString() + Level.HIGH);
        System.out.println(Level.HIGH.ordinal());
        System.out.println(Level.valueOf("HIGH").getLevelCode()); // valueOf(String) returns adequate enum constant
        System.out.println(Enum.valueOf(Level.class, "MEDIUM").getLevelCode());

        // We can use enum in switch
        Level level = Level.HIGH;
        switch (level) {
            case HIGH:
                System.out.println("Do high");
                break;
            case MEDIUM:
                System.out.println("Do medium");
                break;
            case LOW:
                System.out.println("Do low");
                break;
        }

        // Static method values() returns array of all the possible values of the enum type so we can iterate
        for (Level l : Level.values()) {
            System.out.println(l);
        }

    }
}
