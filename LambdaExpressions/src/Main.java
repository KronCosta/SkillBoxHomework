import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";


    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();
        Collections.sort(staff, ((o1, o2) -> {
                    int nameCompare = o1.getName().compareTo(o2.getName());

           if(nameCompare == 0) {

               return o1.getSalary().compareTo(o2.getSalary());


           }
           return nameCompare;



        }));
        System.out.println("\n=========== λSorted name & salaries  ===========");

        for (Employee employee : staff) {
            System.out.println(employee);
        }


        Collections.sort(staff, Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary));


        System.out.println("\n=========== Sorted name & salaries ===========");

        for (Employee employee : staff) {
            System.out.println(employee);
        }
        System.out.println("\n =========== top of 2017 ===========");

        staff.stream().filter(employee -> employee.getWorkStart().getYear() == 117)//2017 - 1900 is normal?
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);

        System.out.println("\n===========+ 10000 salaries ===========");

        System.out.println("\n-> Old salaries*");
        staff.forEach(System.out::println);
        staff.forEach(e ->
                e.setSalary(e.getSalary() + 10000));

        System.out.println("\n=========== new salaries ===========");

        staff.forEach(System.out::println);
    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}