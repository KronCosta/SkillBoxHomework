public class Main {
    public static void main(String[] args) {
        //String alphabetEn = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        //String alphabetRu = "абвгдежзиклмнопостуфхцчШщъыьэюяАБВГДЕЖЗИКЛМНОПРСТУФХЧШЩЪЫЬЭЮЯ";
        // String.prototype.charCodeAt() не понимаю как применить тут и вообще есть ли необходимость.



        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println(i + " " + Integer.valueOf(i));
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.println(i + " " + Integer.valueOf(i) );
        }

        for (char i = 'а'; i <= 'я'; i++)
        {
            System.out.println(i + " " + Integer.valueOf(i));
        }for (char i = 'А'; i <= 'Я'; i++)
        {
            System.out.println(i + " " + Integer.valueOf(i));
        }

    }
}
