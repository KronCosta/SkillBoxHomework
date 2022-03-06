package Score;

public class BankAccount {


    private double mainAccount;

    public BankAccount(double mainAccount) {
        this.mainAccount = mainAccount;
    }


    public  double getMainAccount() {
        return mainAccount;
    }

    public  void inMoney(double money) {
        mainAccount += money;
        System.out.println("Счёт пополнен на : " + money);
    }


    public  void outMoney(double money) {
        mainAccount -= money;
        System.out.println("Со счёта списано : " + money);
    }


    public void scoreValue() {
        System.out.println("Остаток средств на счёте  " + getClass().getName() + " " + mainAccount);
    }

    public void send(BankAccount receiver, double sendMoney)
    {
        int firstCheck = (int) getMainAccount();

        if (firstCheck >= sendMoney) {
            this.outMoney(sendMoney);
            int secondCheck = (int) getMainAccount();
            if (secondCheck == firstCheck - sendMoney || secondCheck == firstCheck - (sendMoney/100) * 101) //Проверка снятия
            {
                receiver.inMoney(sendMoney);

            } else System.out.println("Списание не произошло");

        } else
            System.out.println("Недостаточно средств !");

    }
}

