import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class toDoList {
    public static void main(String[] args) {


        ArrayList<String> todoList = new ArrayList<>() {{
            add("Первое дело");
            add("Второе дело");
            add("Третье дело");
            add("Четвертое дело");

        }};


        System.out.println("Ваш Список дел : ");

        for (int i = 0; i < todoList.size(); i++) {

            System.out.println((i + 1) + ".\t" + todoList.get(i));
        }
        System.out.println(" // Перечень комманд для работы со списком // " +
                " \n\t" + "=> LIST  — выводит дела с их порядковыми номерами." +
                " \n\t" + "=> ADD № наименование — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер." +
                " \n\t" + "=> EDIT № новое наименование— заменяет дело с указанным номером." +
                " \n\t" + "=> DELETE № — удаляет.");
        System.out.println("Введите команду из списка комманд: ");

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {

            String deals = scanner.nextLine();
            Pattern addNum = Pattern.compile("^(ADD)\\s+([\\d]+)\\s+?(.+)$");
            Pattern add = Pattern.compile("^(ADD)\\s+(.+)$");
            Pattern edit = Pattern.compile("^(EDIT)\\s+([\\d]+)\\s+(.+)$");
            Pattern delete = Pattern.compile("^(DELETE)\\s+([\\d]+)$");

            Matcher matcherADDNUM = addNum.matcher(deals);
            Matcher matcherADD = add.matcher(deals);
            Matcher matcherEDIT = edit.matcher(deals);
            Matcher matcherDELETE = delete.matcher(deals);


            if (deals.equals("LIST")) {  //Оставил через if, есть вариант через SWITCH
                System.out.println("Ваш список дел : ");
                for (int i = 0; i < todoList.size(); i++) {
                    System.out.println((i + 1) + ".\t" + todoList.get(i));
                }
            } else if (matcherADDNUM.find()) {

                todoList.add(Integer.parseInt(matcherADDNUM.group(2)) - 1, matcherADDNUM.group(3));

                System.out.println("В список дел добавлено : " + matcherADDNUM.group(3));
                System.out.println("Ваш Список дел : ");
                for (int i = 0; i < todoList.size(); i++) {
                    System.out.println((i + 1) + ".\t" + todoList.get(i));
                }
            }else if (matcherADD.find()){
                todoList.add(matcherADD.group(2));
                System.out.println("В список дел добавлено : " + matcherADD.group(2));
                System.out.println("Ваш Список дел : ");
                for (int i = 0; i < todoList.size(); i++) {
                    System.out.println((i + 1) + ".\t" + todoList.get(i));
                }

            } else if (matcherEDIT.find()) {
                    todoList.remove(Integer.parseInt(matcherEDIT.group(2)) - 1);
                    todoList.add(Integer.parseInt(matcherEDIT.group(2)) - 1, matcherEDIT.group(3));
                    System.out.println("Дело по номером " + matcherEDIT.group(2) + " было изменено. ");
                    System.out.println("Ваш Список дел : ");
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println((i + 1) + ".\t" + todoList.get(i));
                    }

            } else if (matcherDELETE.find()) {

                    todoList.remove(Integer.parseInt(matcherDELETE.group(2)) - 1);
                    System.out.println("Из списка удалено дело под номером" + matcherDELETE.group(2));
                    System.out.println("Ваш Список дел : ");
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println((i + 1) + ".\t" + todoList.get(i));
                    }

            } else if (deals.equals("CLEAR")) {  //Оставил как есть. С доп вопросом удобней ка по мне.
                    System.out.println("Очистить список дел ?");
                    Scanner scanner5 = new Scanner(System.in);
                    String clearAll = scanner5.nextLine();
                    if (clearAll.equals("YES")) {
                        todoList.clear();
                        System.out.println("Список дел очищен.");
                    } else if (clearAll.equals("NO")) {
                        System.out.println("Очистка отменена");
                    }
            }
        }
    }
}

