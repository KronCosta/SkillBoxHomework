import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сколько ящиков направить ?");

        Scanner scanner = new Scanner(System.in);

        int box = scanner.nextInt();

        Cargo cargo = new Cargo(box);
        System.out.println("Для доставки " + cargo.getBox()+ " ящиков " + " необходимо : \n" + " Кол-во втомобилей: " + cargo.getTruck() + "\n Кол-во контейнеров : " + cargo.getContainer());
        cargo.result();
    }
}

