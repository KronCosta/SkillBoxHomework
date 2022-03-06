import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша -  30000 рублей";
//        String allMoney = text.replaceAll("[^0-9,]", "");//решил что будет удобней чем trim()
//        int moneyVasia = Integer.parseInt(allMoney.substring(0,4));
//        int moneyPetr = Integer.parseInt(allMoney.substring(5,9));
//        int moneyMasha = Integer.parseInt(allMoney.substring(10,15));
//        int sumOfMoney = moneyMasha + moneyPetr + moneyVasia;
//        //************************ Второй вариант с использованием indexOf() и lastIndexOf();
//        int vasia, petr, masha;
//        vasia = Integer.parseInt(text.substring((text.indexOf("заработал") + 10), (text.indexOf(" рублей, "))));
//        petr = Integer.parseInt(text.substring((text.indexOf("Петя") + 7),(text.indexOf(" рубля, "))));
//        masha = Integer.parseInt(text.substring((text.indexOf("Маша") + 8), (text.lastIndexOf("0") + 1)));
//        System.out.println(vasia + petr + masha);
//        System.out.println(moneyVasia + " + " + moneyPetr + " + " + moneyMasha + " = " +  sumOfMoney);
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        int sumOfMoney = 0;

        while (matcher.find()) {
            sumOfMoney += Integer.parseInt(matcher.group());
        }
        System.out.println(sumOfMoney);
    }
}