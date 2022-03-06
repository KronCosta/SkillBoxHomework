import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private static final String path = "data/movementList.csv";


    public static void main(String[] args) {

        ArrayList<Detail> check = loadCSV();
        check.sort(Comparator.comparing(Detail -> Detail.getName()));

        Map<String, Double> map = check
                .stream()
                .collect(Collectors.groupingBy
                        (Detail::getName, Collectors.summingDouble(Detail::getSumExpense)));

        System.out.println("Суммы расходов по организациям: \n");
        for (String key : map.keySet()) {
            Double value = map.get(key);
            System.out.println(key + ": " + value);
        }
        System.out.println();


        //Суммы
        double expensesSum = check.stream()
                .mapToDouble(Detail::getSumExpense).sum();
        System.out.println("Сумма расходов : " + expensesSum + " руб.");
        double incomeSum = check.stream()
                .mapToDouble(Detail::getSumIncome).sum();
        System.out.println("Сумма доходов : " + incomeSum + " руб.");

    }

    private static ArrayList<Detail> loadCSV() {
        ArrayList<Detail> check = new ArrayList<>();

        System.out.println(check);
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            lines.remove(0);

            for (String line : lines) {
                String[] elem = line.split(",");

                Pattern clearName = Pattern.compile("^(.+?(?=\\s))(.+?(?=\\\\|\\/))((\\\\.{2,}\\\\|\\/.{2,}\\/))?(.+?(?=\\s{2}))(.+)");
                Matcher m = clearName.matcher(elem[5]);
                m.find();
                check.add(new Detail(m.group(5),
                        Integer.parseInt(elem[6]),
                        Integer.parseInt(elem[7].replaceAll("\\D", ""))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;

    }


}
