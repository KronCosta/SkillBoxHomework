package Clients;

public class IE extends  Client {

    public IE(double mainAccount) {
        super(mainAccount);
    }

    @Override
    public void inMoney(double money) {
        if (money < 1000.00){
            super.inMoney((money - (money/100 * 1)));
        }
        else if(money >= 1000.00){
            super.outMoney(money - (money/100 + 0.5));

        }

    }

}
