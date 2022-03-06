public class TopManager implements Employee {

    private int salary;
    private double prize;
    private Company company;

    public TopManager(int salary) {
        this.salary = salary;

    }

    @Override
    public int getMonthSalary() {

        //double prize 0; // = getCompany().getIncome() > 10000000 ? 2.5 : 1;
        if (this.getCompany().getIncome() > 10000000) {
            prize = 2.5;
        } else prize = 1;

        return (int) (salary * prize);
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public Company getCompany() {
        return company;
    }


    @Override
    public String toString() {
        return getClass().getName() + " : " + getMonthSalary() + " руб.\n";
    }
}




