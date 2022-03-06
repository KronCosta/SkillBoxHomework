public class Temperature {
    public static void main(String[] args)
    {
        Float[] temperature = new Float[30];//Кол- во пациентов

        System.out.print("Температура пациентов : ");
        int j = 0;
        float sum = 0;

        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = ((float)(Math.random()* 8) + 32);//Не стал заводить мининум и максимум
            sum += temperature[i] / 30;

            if(temperature[i] > 36.2 && temperature[i] < 36.9)
            {
                j++;
                continue;
            }

            System.out.print( Math.floor(temperature[i] * 100) / 100 + "  ");//Округлил до 2-х нолей после запятой

        }
        System.out.println();
        System.out.println("Средняя Температура : " + sum);
        System.out.println("Здоровых пациентов : " + j );

    }
}
