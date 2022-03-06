import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Mails { //Первый вариант
    public static void main(String[] args)throws Exception {



        TreeSet<String> mails = new TreeSet<>();
        mails.add("nagibator228@rambler.ru");

        System.out.println("Открыт перечень почтовых адресов.\n" +
                "Команды доступные для работы со списком : \n" +
                "LIST — выводит список электронных адресов. \n" +
                "ADD  — проверяет и, если формат адреса верный, добавляет в множество.");
        Scanner scanner1 = new Scanner(System.in);
        String command = scanner1.nextLine();
        Pattern add = Pattern.compile("^(ADD)\\s+(.+@.+\\..+$)");
        Matcher matcher = add.matcher(command);


        if (command.equals("LIST"))
        {
            System.out.println("Перечень адресов :");
            for (String mail : mails)
            {

                System.out.println("\\t" + mail);
            }
        } else if (matcher.find()) {

                mails.add(matcher.group(2));
                System.out.println(matcher.group(2) + " добавлен в перечень.");
                System.out.println("Перечень адресов :");

                for (String mail : mails) {
                    System.out.println(mail);
                }
        }else System.out.println(" ERROR!");

    }
}



