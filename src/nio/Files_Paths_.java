package nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class Files_Paths_ {

    public static void main(String[] args) throws IOException {
        createFile();
        createDirectory();
        readAtttributes();
        readAllLines();
        copyFile();
        moveFile();
    }

    public static void createFile() throws IOException {
        Path path = Paths.get("res/plik.txt");
        if (Files.notExists(path)) {
            Files.createFile(path); // throws FileAlreadyExistsException if file exists
        }
    }

    public static void createDirectory() throws IOException {
        Path path = Paths.get("res/folderA");
        if (Files.notExists(path)) {
            Files.createDirectory(path);
        }
    }

    public static void readAtttributes() throws IOException {
        createFile();

        BasicFileAttributeView attrView =
                Files.getFileAttributeView(Paths.get("res/plik.txt"), BasicFileAttributeView.class);
        BasicFileAttributes attributes = attrView.readAttributes();
        System.out.println(attributes.size());
        System.out.println(attributes.creationTime());
        System.out.println(attributes.lastModifiedTime());

        AclFileAttributeView aclAttrView =
                Files.getFileAttributeView(Paths.get("res/plik.txt"), AclFileAttributeView.class);
        List<AclEntry> acl = aclAttrView.getAcl();
        for (AclEntry aclEntry : acl) {
            aclEntry.flags().forEach(System.out::println);
            aclEntry.permissions().forEach(System.out::println);
            System.out.println(aclEntry.principal().getName());
        }
    }

    public static void readAllLines() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("res/plik.txt"), Charset.forName("UTF-8"));
        lines.forEach(System.out::println);
    }

    public static void copyFile() throws IOException {
        Files.copy(Paths.get("res/plik.txt"), Paths.get("res/plik2.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void moveFile() throws IOException {
        Files.move(Paths.get("res/plik2.txt"), Paths.get("res/folderA/plik2.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
}
