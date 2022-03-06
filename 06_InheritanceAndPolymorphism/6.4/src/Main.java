import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> stuff = new ArrayList<>();
        Company company = new Company();
        Operator operator = new Operator(10000);//180
        Manager manager = new Manager(20000);//80
        TopManager topManager = new TopManager(30000);//10

        for (int i = 0; i < 180; i++) {//180
            stuff.add(new Operator(10000));

        }
        for (int j = 0; j < 80; j++) {//80
            stuff.add(new Manager(20000));

        }
        for (int k = 0; k < 10; k++) {//10
            stuff.add(new TopManager(30000));

        }

        company.hire(manager);
        company.hire(operator);
        company.hire(topManager);

        System.out.println("Sales of this manager: " + manager.getSales());
        System.out.println("Salary of this manager: " + manager.getMonthSalary());
        System.out.println("Income of his company: " + company.getIncome());
        System.out.println("Salary of this top manager: " + topManager.getMonthSalary());

        company.fire(manager);
        System.out.println("Income of his company: " + company.getIncome());

        company.hireAll(stuff);
        System.out.println("Income of his company: " + company.getIncome());
        System.out.println(company.getTopSalaryStaff(10));
        System.out.println(company.getLowestSalaryStaff(30));
        company.fireHalf();
        System.out.println("Income of his company: " + company.getIncome());
        System.out.println(company.getTopSalaryStaff(10));
        System.out.println(company.getLowestSalaryStaff(30));


    }
}
