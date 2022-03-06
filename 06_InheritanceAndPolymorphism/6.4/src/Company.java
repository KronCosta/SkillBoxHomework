import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Company {

    private final ArrayList<Employee> company = new ArrayList<>();


    public int getIncome() {
        int income = 0;
        for (Employee employee : company) {
            if (employee instanceof Manager) {
                income += ((Manager) employee).getSales();
            }

        }
        return income;
    }


    public void hire(Employee employee) {
        employee.setCompany(this);
        company.add(employee);

    }

    public void hireAll(List<Employee> employees) {
        employees.forEach(employee -> employee.setCompany(this));
        company.addAll(employees);
    }


    public void fire(Employee employee) {
        employee.setCompany(null);
        company.remove(employee);

    }

    public void fireHalf() {
        int count = company.size();
        for (int i = 0; i < count / 2; i++) {
            fire(company.get(i));

        }

    }

    public List<Employee> getTopSalaryStaff(int count) {
        return company.stream()
                .sorted(Comparator.comparing(Employee::getMonthSalary).reversed())
                .limit(count)
                .collect(Collectors.toList());


    }


    public List<Employee> getLowestSalaryStaff(int count) {
        return company.stream()
                .sorted(Comparator.comparing(Employee::getMonthSalary))
                .limit(count)
                .collect(Collectors.toList());
    }

}
