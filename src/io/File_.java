package io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class File_ {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, URISyntaxException {

        System.out.println(File.pathSeparator + File.pathSeparatorChar);
        System.out.println(File.separator + File.separatorChar);

        for (File file : File.listRoots()) {
            System.out.println(file);
        }

        String path = "d:/dane.txt";
        String uri = "file:///D:/dane2.txt";
        File fstr = new File(path);
        File furi = new File(new URI(uri));
        furi.createNewFile();
        System.out.println((Boolean.valueOf(furi.canExecute())).toString() + " " + furi.canRead() + " " + furi.canWrite());
        System.out.println(furi.exists());
        //furi.delete();
        //furi.deleteOnExit();


        // Temporary files
        File tmpf;
        tmpf = File.createTempFile("tmpfile", null);
        tmpf = File.createTempFile("dane1", "txt", new File("d:/"));
        tmpf.deleteOnExit();
        //sc.next();


    }

    public static void createFile() throws IOException {
        File file = new File("res/plik.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
