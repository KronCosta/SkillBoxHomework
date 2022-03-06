import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

//    static boolean isPerfectString(String a) {
//        if (a.length() == 0) return false;
//        for (int i = 0; i < a.length(); i++) {
//            if(!Character.isLetter(a.charAt(i))) return false;
//            if ((i == 0 && !Character.isUpperCase(a.charAt(i))) ||
//                    (i != 0 && !Character.isLowerCase(a.charAt(i))))
//                return false;
//        }
//        return true;
//    }


    public static void main(String[] args) throws Exception {

        System.out.println(" Введите Ф.И.О.:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fullName = reader.readLine();
        String regEx = "^([А-ЯЁ][а-яё]+(-[А-Я][а-яё]+)?)\\s([А-ЯЁ][а-яё]+(-[-А-Я][а-яё]+)?)\\s([А-ЯЁ][а-яё]+(\\s[а-я]+)?)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(fullName);
        matcher.find();
        if(!fullName.matches(fullName)) {
            System.out.println("Ошибка ввода ");
        } else
        System.out.println("Фамилия: " + matcher.group(1) + "\t\nИмя: " + matcher.group(3) + "\t\nОтчество: " + matcher.group(5));
    }
}


//        int space = fullName.length() - fullName.replace(" ", "").length();
//        if (space != 2) {
//
//            System.out.println("Ошибка ввода.");
//
//        } else {
//            int firstIndex = fullName.indexOf(" ");
//            int lastIndex = fullName.lastIndexOf(" ");
//            String secondName = fullName.substring(0, firstIndex);
//            String firstName = fullName.substring(firstIndex + 1, lastIndex);
//            String otherName = fullName.substring(lastIndex + 1);
//
//
//            if (isPerfectString(secondName) && isPerfectString(firstName) && isPerfectString(otherName)) {
//                System.out.println("Фамилия: " + secondName + "\t\nИмя: " + firstName + "\t\nОтчество: " + otherName);
//
//            } else System.out.println(" Введены некорректные данные ");
//
//        }
//    }
//}








