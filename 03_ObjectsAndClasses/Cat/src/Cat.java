public class Cat
{
    public static final int LEGS_COUNT = 4;
    public static final int EYES_COUNT = 2;
    public static final int MIN_WEIGHT = 1000;
    public static final int MAX_WEIGHT = 9000;


    private double originWeight;
    private double weight;
    private double minWeight;
    private double maxWeight;
    private double foodAmount;
    private String name;
    public Skin color;
    public static int count = 0;// Урок 3.
    public boolean Tail;





    public boolean catAlive()
    {
        return getWeight() >= minWeight && getWeight() <= maxWeight;
    }



    public Cat()

    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;

    }

    public static int getCount()
    {
        return count;
    }
    public Cat(String name, Double weight, Skin color){
        this.name = name;
        this.weight = weight;
        this.color = color;

    }




    public void isAlive() { //Задание 6
        if (catAlive()) {
            System.out.println("Кот живой");
        } else System.out.println("Кот не живой");
    }
    public void hasTail() {
        if (Tail) {
            System.out.println("Хвост есть");
        }else System.out.println("Хвоста нет");

    }
    public Cat (Cat other){ //Задание 7
        this();
        this.name = other.name;
        this.weight = other.weight;
        this.color = other.color;


    }


    public void setSkinType(Skin color)
    {

    }



    public void isColor(Skin color) //Задание 6
    {
        this.color = color;
    }

    public Skin hasColor() //Задание 6
    {
        return color;
    }

    public Cat(String name)
    {
        this();
        this.name = name;
    }

    public Cat(Double weight) //Задание 5
    {
        this.weight = weight;
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
    }




    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
     return name;
    }


    public void meow()
    {
        if(catAlive())
            weight = weight - 180;
        System.out.println("Meow");
        if(!catAlive()){
            count--;
        }

    }

    public  void feed(Double amount)
    {
        if (catAlive()) {
            weight = weight + amount;
            foodAmount += amount;
            System.out.println("Yammy " + amount);
            if (!catAlive()) {
                count--;
            }
        }
    }


    public void pee(Double amount)
    {
        if(catAlive())
            weight = weight - amount;
        System.out.println("murmur");
        if (!catAlive()) {
            count--;
        }

    }


    public void drink(Double amount)
    {
        if(catAlive())
        weight = weight + amount;
        else System.out.println("Cat is dead!");
        if (!catAlive()) {
            count--;
        }
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
    public Double eatStatus()
    {
        return foodAmount;
    }

}

