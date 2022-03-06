public class Cargo {
    private int car;
    private int container;
    private int box;
    public Cargo(int box)
    {
        this.box = box;
        if(box!=0){
            container = box % 27 == 0 ? box / 27 : box / 27 + 1;
        }
        if(container !=0){
            car = container % 12 == 0 ? container / 12 : container /12 + 1;
        }
    }
    public int getTruck()
    {
        return car;
    }
    public int getContainer()
    {
        return container;
    }
    public int getBox()
    {
        return box;
    }
    public void result()
    {
        int bx = 1;
        int cont = 1;
        for(int i = 1; i <= car; i++){
            System.out.println("Автомобиль " + i);
            int a = 0;
            while (a < 12 && cont <= container){
                System.out.println( "\tКонтейнер : " + cont);
                int q = 0;
                while (q < 27 && bx <= box)
                {
                    System.out.println( "\t\tКоробка - " + bx);
                    q++;
                    bx++;
                }
                a++;
                cont++;
                System.out.println();
            }
        }
    }
}
