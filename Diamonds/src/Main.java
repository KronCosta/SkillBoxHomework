import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String text = "Н<омер кр>е<дит>ной <карты> <4008 1234 5678> 8912";
    public static void main(String[] args) {

        System.out.println(text.replaceAll("\\<.*?\\>",""));

       // }

    }
//    private static  String replaceDiamond(String a, String b)
//        {
//            String c = a.substring(a.indexOf("<"),(a.lastIndexOf(">") +1));
//            b = "*****";
//            return a.replace(c,b);
//        }
}
