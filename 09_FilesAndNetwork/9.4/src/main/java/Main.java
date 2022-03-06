
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;


public class Main {
    private static final String URL = "https://lenta.ru/";
    private static final String imgPath = "images";

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect(URL)
                    .userAgent("Chrome/87.0.4280.88")
                    .referrer("http://www.google.com")
                    .get();
            Elements images = doc
                    .select("img ");
            for (Element element : images) {
                String src = element.absUrl("src");
               saveImage(src);
//               System.out.println(src);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveImage(String src) throws Exception {

        int nameIndex = src.lastIndexOf("/");
        if (nameIndex == src.length()) {
            src = src.substring(1, nameIndex);
        }
        nameIndex = src.lastIndexOf("/");
        String name = src.substring(nameIndex, src.length());
        URL url = new URL(src);
        InputStream in = url.openStream();
        OutputStream out = new BufferedOutputStream(new FileOutputStream(imgPath + name));
        for (int i; (i = in.read()) != 1; ) {
            out.write(i);
        }
        out.close();
        in.close();

    }
}
