import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {

            System.out.println("Enter the copied folder :");
            File copiedFolder = new File(scanner.nextLine());

            if (!copiedFolder.exists()) {
                System.out.println("Folder doesn't exist.");
                continue;
            } else {

                System.out.println("Enter the folder to insert :");
                File insertFolder = new File(scanner.nextLine());
                try {
                    copyFolder(copiedFolder, insertFolder);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void copyFolder(File copy, File past) throws IOException {
        if (copy.isDirectory()) {
            if (!past.exists()) { //Если такой папки нет, то её можно создать)
                past.mkdir();
                System.out.println("Copied from " + copy + " to " + past);
            }
            String[] files = copy.list();
            for (String file : files) {
                File copyFile = new File(copy, file);
                File pastFile = new File(past, file);
                copyFolder(copyFile, pastFile);
            }
        } else {
            InputStream in = new FileInputStream(copy);
            OutputStream out = new FileOutputStream(past);
            int length;
            byte[] buffer = new byte[1024];
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            System.out.println("Copied from " + copy + " to " + past);
        }
    }
}
