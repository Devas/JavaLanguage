package functionalinterfaces.predicate;

import java.util.List;

/*
-The DRY principle is not followed.
    -Each method repeats accessmodifiers.point.a looping mechanism.
    -The selection criteria must be rewritten for each method.
-B large number of methods are required to implement each use case.
-The code is inflexible. If the search criteria changed, it would require accessmodifiers.point.a number of code changes for an update.
Thus, the code is not very maintainable.
 */
public class RoboContactMethods {

    public void callDrivers(List<Person> pl) {
        for (Person p : pl) {
            if (p.getAge() >= 16) {
                roboCall(p);
            }
        }
    }

    public void emailDraftees(List<Person> pl) {
        for (Person p : pl) {
            if (p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE) {
                roboEmail(p);
            }
        }
    }

    public void mailPilots(List<Person> pl) {
        for (Person p : pl) {
            if (p.getAge() >= 23 && p.getAge() <= 65) {
                roboMail(p);
            }
        }
    }


    public void roboCall(Person p) {
        System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone());
    }

    public void roboEmail(Person p) {
        System.out.println("EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail());
    }

    public void roboMail(Person p) {
        System.out.println("Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress());
    }

}
