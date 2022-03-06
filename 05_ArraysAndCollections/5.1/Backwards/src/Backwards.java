import java.util.Arrays;

public class Backwards {
    public static void main(String[] args)
    {
        String text = "Каждый охотник желает знать, где сидит фазан.";
        String[] colors = text.split(",?\\s+");




        for (int i = 0; i < colors.length/2; ++i)
        {
            String tmp = colors[i];//переменная для сохранения прошлого значения "i"
            colors[i] = colors[colors.length - 1 - i];
            colors[colors.length - 1 - i] = tmp;
//            System.out.println(colors);//так не работает

        }
        System.out.print(Arrays.toString(colors));//Так работает

    }
}
