package Score;

public class Card extends BankAccount {


    public Card(double mainAccount) {
        super(mainAccount);
    }


    @Override
    public void outMoney(double money){
        super.outMoney((money/100) * 101);
        System.out.println("Списание с карты : " + money + " комиссия 1% : " + (money/100));
    }

    


}