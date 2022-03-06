package Clients;

import Score.BankAccount;

public abstract class Client extends BankAccount
{

    public  Client(double mainAccount) {
        super(mainAccount);
    }

    @Override
    public void scoreValue() {
        super.scoreValue();
    }

    public void inMoney(double money){
        super.inMoney(money);
    }

    public  void outMoney(double money){
        super.outMoney(money);
    }
}
