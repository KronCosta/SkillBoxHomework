public class Manager implements Employee {


    private int sales = (int) ((Math.random() * (140000 - 115000 + 1) + 115000));


    public int getSales() {

        return sales;
    }


    private int salary;

    public Manager(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        return salary + (sales / 100) * 5;
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


