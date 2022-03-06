
public class Loader {
    public static void main(String[] args) {
        Cat jmoorka = new Cat("Жмурка");
        System.out.println(jmoorka.getName());
        jmoorka.setSkinType(Skin.WHITE);
        jmoorka.isColor(Skin.GRAY); // Задание 6.2 выдаёт пустую строку?
        jmoorka.hasColor();
        jmoorka.Tail = Math.random() < 0.30; // Задание 6 хвост
        jmoorka.hasTail();
        System.out.println();
        System.out.println("Вес  Жмурки = " + jmoorka.getWeight());
        System.out.println("Состояние  кошки: " + jmoorka.getStatus());
        //System.out.println("Цвет Жмурки :" + jmoorka.getSkin());
        System.out.println("*");

        Cat fosia = new Cat("Фося");
        System.out.println(fosia.getName());
        fosia.Tail = Math.random() < 0.60; // Хвост
        fosia.hasTail(); // 6 хвост
        System.out.println("Вес  Фоси = " + fosia.getWeight());
        System.out.println("Состояние  кота: " + fosia.getStatus());
        System.out.println("Итого котов : " + Cat.count);
        System.out.println("*");

        Cat gmich = new Cat("Жмых");
        System.out.println(gmich.getName());
        System.out.println("Вес  Жмыха = " + gmich.getWeight());
        System.out.println("Состояние  кота: " + gmich.getStatus());
        System.out.println("*");

        Cat iakov = new Cat("Яков");
        System.out.println(iakov.getName());
        System.out.println("Вес  Якова = " + iakov.getWeight());
        System.out.println("Состояние  кота: " + iakov.getStatus());
        System.out.println("Итого котов : " + Cat.count);
        System.out.println("*");

        System.out.println(".....................................");
        while (jmoorka.getStatus() == "Dead" == false)
            jmoorka.meow();
        System.out.println("Вес  Жмурки = " + jmoorka.getWeight());
        System.out.println("Состояние  кошки:" + jmoorka.getStatus());
        System.out.println(".....................................");

        while (fosia.catAlive()) {
            fosia.feed(500.0);
        }
        fosia.feed(fosia.getWeight() / 10);
        System.out.println("Съедено " + fosia.eatStatus());
        System.out.println("Вес  Фоси = " + fosia.getWeight());
        System.out.println("Состояние  кота:" + fosia.getStatus());
        fosia.feed(fosia.getWeight() / 10);
        fosia.feed(fosia.getWeight() / 10);
        fosia.feed(fosia.getWeight() / 10);
        fosia.feed(fosia.getWeight() / 10);
        fosia.isAlive();
        System.out.println(".....................................");

        gmich.drink(gmich.getWeight() / 100);
        System.out.println("Съедено " + gmich.eatStatus());
        System.out.println("Вес  Жмыха = " + gmich.getWeight());
        System.out.println("Состояние  кота: " + gmich.getStatus());
        System.out.println(".....................................");

        iakov.pee(iakov.getWeight() / 1000);
        System.out.println("Вес  Якова = " + iakov.getWeight());
        System.out.println("Состояние кота: " + iakov.getStatus());
        System.out.println("Итого котов : " + Cat.getCount());
        iakov.isAlive();
        getKitten();
        System.out.println("Итого котов : " + Cat.getCount());

        Cat projectX =  new Cat(jmoorka);

        System.out.print("Вес x : " + projectX.getWeight() + " vs ");          //Строки для сравнения
        System.out.println("Вес  Жмурки = " + jmoorka.getWeight());
        System.out.print("Цвет x : " + projectX.hasColor() + " vs ");
        System.out.println(" Цвет мурки : " + jmoorka.hasColor());
        System.out.print("Имя x : " + projectX.getName() + " vs ");
        System.out.println(" Кошку зовут - " + jmoorka.getName());




    }

    public static Cat getKitten() {
        return new Cat(1100.00);

    }



}




