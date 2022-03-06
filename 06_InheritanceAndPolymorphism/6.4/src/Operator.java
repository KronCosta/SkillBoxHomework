public class Operator implements Employee {
    private int salary;

    public Operator(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public void setCompany(Company company) {

    }

    @Override
    public Company getCompany() {

        return null;
    }

    @Override
    public String toString() {
        return getClass().getName() + " : " + getMonthSalary() + " руб.\n";
    }
}



