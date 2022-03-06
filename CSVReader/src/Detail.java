public class Detail {
    private String name;
    private double sumIncome;
    private double sumExpense;

    @Override
    public String toString() {
        return name + " " + "сумма прихода : " + sumIncome + " руб. / " + "сумма расхода :"
                + sumExpense + " руб.\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSumIncome() {
        return sumIncome;
    }

    public void setSumIncome(int sumIncome) {
        this.sumIncome = sumIncome;
    }

    public double getSumExpense() {
        return sumExpense;
    }

    public void setSumExpense(int sumExpense) {
        this.sumExpense = sumExpense;
    }

    public Detail(String name, int sumIncome, int sumExpense) {
        this.name = name;
        this.sumIncome = sumIncome;
        this.sumExpense = sumExpense;
    }
}
