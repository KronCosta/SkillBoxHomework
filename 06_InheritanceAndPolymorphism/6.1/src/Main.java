import Clients.Entity;
import Clients.IE;
import Clients.Individual;
import Score.BankAccount;
import Score.Card;
import Score.Deposit;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(0);
        Deposit deposit = new Deposit(10000);
        Card card = new Card(20000);


        System.out.println("Deposit check");
        deposit.scoreValue();
        deposit.inMoney(1000);
        deposit.scoreValue();
        deposit.outMoney(1000);
        deposit.send(account,1000);
        deposit.scoreValue();
        account.scoreValue();
        System.out.println();

        System.out.println("Card check");
        card.scoreValue();
        card.inMoney(1000);
        card.scoreValue();
        card.outMoney(1000);
        card.scoreValue();
        card.send(account,1000);
        card.scoreValue();
        account.scoreValue();
        System.out.println();

        System.out.println("Individual check");
        Individual individual = new Individual(10000);
        individual.scoreValue();
        individual.inMoney(1000);
        individual.scoreValue();
        individual.outMoney(1000);
        individual.scoreValue();
        individual.send(account,1000);
        individual.scoreValue();
        account.scoreValue();
        System.out.println();

        System.out.println("Entity check");
        Entity entity = new Entity(100000);
        entity.scoreValue();
        entity.inMoney(1000);
        entity.scoreValue();
        entity.outMoney(1000);
        entity.scoreValue();
        entity.send(account,1000);
        entity.scoreValue();
        account.scoreValue();
        System.out.println();


        System.out.println("IE check");
        IE ie = new IE(100000);
        ie.scoreValue();
        ie.inMoney(1000);
        ie.scoreValue();
        ie.outMoney(1000);
        ie.scoreValue();
        ie.send(account,1000);
        ie.scoreValue();
        account.scoreValue();
        System.out.println();





    }
}
