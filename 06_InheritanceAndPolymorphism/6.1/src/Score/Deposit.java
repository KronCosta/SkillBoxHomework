package Score;
import java.time.LocalDate;

public class Deposit extends BankAccount {


     private static LocalDate paymentDate;

    public Deposit(double mainAccount)
    {
        super(mainAccount);

    }



    @Override
    public void inMoney(double money) {
        paymentDate = LocalDate.now();
         super.inMoney(money);
        System.out.println("Депозит пополнен " + paymentDate + " на сумму: " + money);
    }

    @Override
    public void outMoney(double money){
        LocalDate debitDate = LocalDate.now();

        if (debitDate.isAfter(paymentDate.plusMonths(1))){

            super.outMoney(money);
            System.out.println("Снятие средств с депозита :" + money);


        } else {
            System.out.println("С момента пополнения " + paymentDate + " не прошло месяца. ");
        }
    }
}


