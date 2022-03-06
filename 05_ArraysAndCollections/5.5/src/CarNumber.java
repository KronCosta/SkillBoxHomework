import java.util.*;

public class CarNumber {


    public static void main(String[] args) {

        String[] letter = {"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У", "Х", "К"};

        ArrayList<String> numbers = new ArrayList<>();
        Collections.sort(numbers);

        long startBuild = System.nanoTime();
        for (int i = 111; i <= 999; i += 111) {
            for (int j = 0; j < letter.length; j++) {
                for (int j2 = 0; j2 < letter.length; j2++) {
                    for (int k = 0; k < letter.length; k++) {
                        for (int region = 1; region <= 199; region++) {
                            String number = String.format("%s%03d%s%s%02d", letter[j], i, letter[j2], letter[k], region);
                            numbers.add(number);
                        }
                    }
                }
            }
        }
        long endBuild = System.nanoTime();

        Collections.sort(numbers);
        for (int i = 0; i <= 5; i++) {
            System.out.println(numbers.get(i));

        }
        System.out.println("На построение затрачено : " + (endBuild - startBuild) + " нс");
        System.out.println(numbers.size());

       Set<String> hash = new HashSet<>(numbers);
       Set<String> tree = new TreeSet<>(numbers);

       Scanner scanner = new Scanner(System.in);
       for (; ; ) {

           System.out.println("Введите искомый номер :");
           String command = scanner.nextLine();

           long start1 = System.nanoTime();
           if (numbers.contains(command)) {
               long final1 = System.nanoTime();
               System.out.println("Поиск перебором: номер " + command + " найден, поиск занял " + (final1 - start1) + " нс");

           } else {
               long end1 = System.nanoTime();
               System.out.println("Поиск перебором: номер не найден, поиск занял " + (end1 - start1) + "нс");
           }


           long start2 = System.nanoTime();
           if (Collections.binarySearch(numbers, command) >= 0) {
               long final2 = System.nanoTime();
               System.out.println("Бинарный поиск: номер " + command + " найден, поиск занял " + (final2 - start2) + " нс");

           } else {
               long end2 = System.nanoTime();
               System.out.println("Бинарный поиск: номер не найден, поиск занял " + (end2 - start2) + "нс");
           }

           long start3 = System.nanoTime();
           if (hash.contains(command)) {
               long final3 = System.nanoTime();

               System.out.println("Поиск HashSet: номер " + command + " найден, поиск занял " + (final3 - start3) + " нс");

           } else {
               long end3 = System.nanoTime();
               System.out.println("HashSet поиск: номер не найден, поиск занял " + (end3 - start3) + "нс");
           }

           long start4 = System.nanoTime();
           if (tree.contains(command)) {
               long final4 = System.nanoTime();

               System.out.println("Поиск TreeSet: номер " + command + " найден, поиск занял " + (final4 - start4) + " нс");

           } else{
               long end4 = System.nanoTime();
               System.out.println("TreeSet поиск: номер не найден, поиск занял " + (end4 - start3) + "нс");
           }
       }
    }
}

//    public static boolean linearSearch(ArrayList<String> arr, String command) {
//        return arr.contains(command);
//    }
//}


