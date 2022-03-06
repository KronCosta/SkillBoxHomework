import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cleaner {
    public static void main(String[] args) throws Exception {
        String regEx = "^[78]?-?\\(?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}$"; //Пропускает всё вроде бы

        System.out.println(" Введите номер :");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String number = reader.readLine();
        String clearNubmer = number.replaceAll("[^\\d]","");//Убирал мусорные знаки
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(number);
        matcher.find();

        if(clearNubmer.matches(clearNubmer) && clearNubmer.length() == 11){  //пытался сделать через charAT(0) == 8 || == 7, но не работало почему-то.

            System.out.println("+7" + clearNubmer.substring(1));

        }
        else if (clearNubmer.matches(clearNubmer) && clearNubmer.length() == 10){
                System.out.println("+7" + clearNubmer);
        }
        else if (clearNubmer.matches(clearNubmer)){
                System.out.println(clearNubmer);

        }

    }

}
