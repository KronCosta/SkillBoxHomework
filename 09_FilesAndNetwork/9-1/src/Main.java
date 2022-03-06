import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            try {
                System.out.println("Введите путь к папке : ");
                File folder = new File(scanner.nextLine());
                if (folder.isDirectory()) {
                    File[] files = folder.listFiles();
                    for (File file : files) {

                        System.out.println(file.getAbsolutePath());


                    }System.out.println("Общий размер : " + sizeConverter(sizeOfFolder(folder)));

                } else System.out.println("Неверный ввод пути");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static String sizeConverter(long size) {

        if (size < 1024) return ":" + size + " Б";

        int exp = (int) (Math.log(size) / (Math.log(1024)));

        char unitsPrefix = "КМГТПЭ".charAt(exp - 1);

        return String.format("%.2f%sБ ", size / Math.pow(1024, exp), " " + unitsPrefix);

    }

    public static long sizeOfFolder(File folder) {
        long size = 0;
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                // System.out.println(file.getName() + " " + file.length());
                size += file.length();

            } else size += sizeOfFolder(file);
        }
        return size;
    }

//    private static long printFormatSize(long size) { //работает достаточно точно как по мне )
//
//        if (size >= 1073741824) {
//            System.out.println("Размер указанной папки: " + size / 1073741824 + " Гб");
//        } else if (size >= 1048576) {
//            System.out.println("Размер указанной папки: " + size / 1048576 + " Мб");
//        } else if (size >= 1024) {
//            System.out.println("Размер указанной папки: " + size / 1024 + " Кб");
//        } else if (size >= 1) {
//            System.out.println("Размер указанной папки: " + size + " байт");
//        }
//        return size;
//    }
}
