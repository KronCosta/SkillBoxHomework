
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;


public class Main {
    private static final String URL = "https://lenta.ru/";
    private static final String imgPath = "D:\\Learn\\SkillBOX\\Projects\\09_FilesAndNetwork\\ParserHtml\\images\\";

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect(URL)
                    .userAgent("Chrome/87.0.4280.88")
                    .referrer("http://www.google.com")
                    .get();
            Elements images = doc
                    .select("img ");

            for (Element element : images) {
                String src = element.attr("abs:src");
                try {
                    download(src);
                }catch (Exception e){
                    System.out.println("Ссылка error" + src);
                }
//               System.out.println(src);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void download(String src) {
        String imgName = src.substring(src.lastIndexOf('/') + 1);
        System.out.println("Скачано : " + imgName + " по ссылке : " + src);
       // if (!imgName.equals("top100.cnt?pid=80674")) { //сделал пока так


            try {
                URL urlIMG = new URL(src);
                InputStream in = urlIMG.openStream();
                byte[] buffer = new byte[4096];
                int i = -1;
                OutputStream out = new FileOutputStream(imgPath + "/" + imgName);
                while ((i = in.read(buffer)) != -1) {
                    out.write(buffer, 0, i);
                }
                out.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }



//    private static void saveImage(String src) throws Exception { //don't working
//
//        int nameIndex = src.lastIndexOf("/");
//        if (nameIndex == src.length()) {
//            src = src.substring(1, nameIndex);
//        }
//        nameIndex = src.lastIndexOf("/");
//        String name = src.substring(nameIndex, src.length());
//        URL url = new URL(src);
//        InputStream in = url.openStream();
//        OutputStream out = new BufferedOutputStream(new FileOutputStream(imgPath + name));
//        for (int i; (i = in.read()) != 1; ) {
//            out.write(i);
//        }
//        out.close();
//        in.close();
//
//    }

