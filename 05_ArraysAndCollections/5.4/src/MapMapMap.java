import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MapMapMap {
    public static void main(String[] args) {
        Properties properties = System.getProperties();

        HashMap<String, String> phoneBook = new HashMap<>();


        phoneBook.put("89505149850", "Евпат");
        phoneBook.put("5465465", "Артём");
        phoneBook.put("8978465", "Вера");
        phoneBook.put("1654132", "Яков");
        phoneBook.put("554045", "Денис");

        Pattern k = Pattern.compile("^\\d{4,}$");
        Pattern v = Pattern.compile("^[а-яА-ЯёЁ]+$");



        Scanner scanner1 = new Scanner(System.in);
        for (; ; ) {
            String command = scanner1.nextLine();

            if (command.equals("LIST")) {

                phoneBook.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .forEach(e -> System.out.println(e.getValue() + " - " + e.getKey()));

            } else if (command.matches(String.valueOf(k))) {//номер
                if (phoneBook.containsKey(command)) {//номер есть в базе
                    System.out.println(command + "  " + phoneBook.get(command));//печать по номеру
                } else {//номера нет в базе
                    System.out.println("Введите имя :");
                    String name = scanner1.nextLine();//имя для номера
                    if (name.matches(String.valueOf(v))) {
                        phoneBook.put(command, name);//добавил в базу
                    }else {System.out.println("Неверный формат имени");
                }
                    }
            } else if (command.matches(String.valueOf(v))) {//имя
                if (!phoneBook.containsValue(command)) {//имени нет
                    System.out.println("Введите  номер");
                    String number = scanner1.nextLine();
                    if (number.matches(String.valueOf(k))) {
                        phoneBook.put(number, command);
                    }else System.out.println("Неверный формат номера");

                } else {
                    System.out.println(getKey(phoneBook, command) +"  "+ phoneBook.get(getKey(phoneBook, command)));

                }

            } else {
                System.out.println("ERROR");
            }
        }
    }


        public static <K, V > K getKey(Map < K, V > map, V value) {//перебор для поиска совпадений Value
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (entry.getValue().equals(value)) {
                    return entry.getKey();
                }
            }
            return null;
    }
}



