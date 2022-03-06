import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Resizer implements Runnable {

    private final File[] files;
    private final String dstFolder;
    private final long start;

    public Resizer(File[] files, String dstFolder, int newWidth, long start) {
        this.files = files;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {

        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }
                BufferedImage newImage = Scalr.resize(Scalr.resize(image, Scalr.Method.SPEED, 600), Scalr.Method.ULTRA_QUALITY, 300); // Done*
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Finish after : " + (System.currentTimeMillis() - start) + " ms");
    }
}