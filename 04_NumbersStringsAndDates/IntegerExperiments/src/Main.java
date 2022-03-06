public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

    }

    public static int sumDigits(Integer number)
    {
        String str = number.toString();
        //int length = str.length();
        int sum = 0;

        for(int i = 0; i < str.length(); i++)
        {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return sum;
    }
    static {
        System.out.println(sumDigits(12345));
    }

}

