package Clients;

public  class Entity extends Client{
    public Entity(double mainAccount) {
        super(mainAccount);
    }


    @Override
    public void outMoney(double money) {
        super.outMoney((money/100) * 101);
    }


}
