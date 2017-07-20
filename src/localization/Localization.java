package localization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

class A implements Cloneable {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Object();
    }
}

public class Localization {

    public static void main(String[] args) throws IOException {
        /*ResourceBundle myResources = ResourceBundle.getBundle("MyResources");

        for (String key : myResources.keySet()) {
            System.out.println(key + ": " + myResources.getString(key));
        }*/
        f();
        f("accessmodifiers.point.a");
        f("accessmodifiers.point.a", "accessmodifiers.point.b", "c");

        List l1, l2;
        l1 = new ArrayList();
        l2 = l1;
        //l2 = (List)l1.clone();

        Properties p = System.getProperties();
        p.list(System.out);
        p = new Properties();
//        p.load(new FileInputStream("properties.txt"));
        p.load(new FileInputStream(new File("res/properties.txt")));
        p.storeToXML(new FileOutputStream("properties.txt"), "");

    }

    static void f(String... params) {
        for (String s : params) {
            System.out.println(s);
        }
    }


}
