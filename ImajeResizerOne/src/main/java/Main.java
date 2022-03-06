
import java.io.File;
import java.util.ArrayList;

public class Main {

    public static int newWidth = 300;
    static final String srcFolder = "K:\\Download\\image\\src"; // откуда
    static final String dstFolder = "K:\\Download\\image\\dst"; // куда

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        starter(srcFolder,dstFolder,start);
        
    }

    public static Resizer resizer(File[] files, int mid, String dstFolder, long start, int i) {
        int srcPos = mid * i;
        File[] files1 = new File[mid];
        System.arraycopy(files, srcPos, files1, 0, files1.length);
        return new Resizer(files1, dstFolder, newWidth, start);
    }

    public static void starter(String srcFolder, String dstFolder, Long start) {
        ArrayList<Thread> threads = new ArrayList<>();
        File srcDir = new File(srcFolder);
        File[] srsFiles = srcDir.listFiles();
        int cpu = Runtime.getRuntime().availableProcessors(); //ядра
        int count = srsFiles != null ? srsFiles.length : 0; //кол-во файлов
        int mid = count / cpu;  //колво потоков
        
        for (int i = 0; i < cpu; i++) {
            threads.add(new Thread(resizer(srsFiles, mid, dstFolder, start, i)));
        }
        for (Thread thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
}


