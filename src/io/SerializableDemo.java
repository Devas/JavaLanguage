package io;

import java.io.*;

public class SerializableDemo {

    public static class Person implements Serializable {
        private static final long serialVersionUID = 3085463852891207485L;
        public String name = null;
        public int age = 0;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String path = "res/person.bin";
        File file = new File(path);
        file.createNewFile();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));

        Person person = new Person();
        person.name = "Jakob Jenkov";
        person.age = 40;

        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));

        Person personRead = (Person) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println(personRead.name);
        System.out.println(personRead.age);
    }
}
