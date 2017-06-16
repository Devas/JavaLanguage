package bestpractices.copyconstructor;

/**
 * Instead of using Cloneable we should use copy constructor.
 * We have also available here static getInstance() method which uses copy constructor.
 *
 * For immutable objects copy constructors are unnecessary.
 * Because the value cannot change, it's every bit as good to reference the same object in all cases,
 * there's no need to have an "extra copy".
 * There's no point in having two instances of equal immutable objects - just use the same instance everywhere.
 *
 * // TODO Defensive Copying
 * http://www.javapractices.com/topic/TopicAction.do?Id=15
 */
public final class Galaxy {

    private double fMass;
    private final String fName;

    /**
     * Regular constructor.
     */
    public Galaxy(double aMass, String aName) {
        fMass = aMass;
        fName = aName;
    }

    /**
     * Copy constructor.
     */
    public Galaxy(Galaxy aGalaxy) {
        this(aGalaxy.getMass(), aGalaxy.getName());
        //no defensive copies are created here, since
        //there are no mutable object fields (String is immutable)
    }

    /**
     * Alternative style for a copy constructor, using a static newInstance
     * method.
     */
    public static Galaxy newInstance(Galaxy aGalaxy) {
        return new Galaxy(aGalaxy.getMass(), aGalaxy.getName());
    }

    public double getMass() {
        return fMass;
    }

    /**
     * This is the only method which changes the state of a Galaxy object.
     * If this method were removed, then a copy constructor would not be provided either, since immutable objects
     * do not need a copy constructor.
     */
    public void setMass(double aMass) {
        fMass = aMass;
    }

    public String getName() {
        return fName;
    }

    public static void main(String... aArguments) {
        Galaxy m101 = new Galaxy(15.0, "M101");

        Galaxy m101CopyOne = new Galaxy(m101);
        m101CopyOne.setMass(25.0);
        System.out.println("M101 mass: " + m101.getMass());
        System.out.println("M101Copy mass: " + m101CopyOne.getMass());

        Galaxy m101CopyTwo = Galaxy.newInstance(m101);
        m101CopyTwo.setMass(35.0);
        System.out.println("M101 mass: " + m101.getMass());
        System.out.println("M101CopyTwo mass: " + m101CopyTwo.getMass());
    }

}