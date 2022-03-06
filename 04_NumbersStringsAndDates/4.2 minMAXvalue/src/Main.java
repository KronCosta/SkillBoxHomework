
public class Main {
    public static void main(String args[]){
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);

//        System.out.println(Float.MIN_VALUE);
//        System.out.println(Float.MAX_VALUE);
        //Разбивку по битам значения я отразил для себя, но с отрицательными значениями не разобрался.
        int bitsF = Float.floatToIntBits(-0.005f);
        int signF = bitsF >>> 31;
        int expF = (bitsF >>> 23 & ((1 << 8) - 1)) - ((1 << 7) - 1);
        int mantissaF = bitsF & ((1 << 23) - 1);
        System.out.println("float " + signF + " " + expF + " " + mantissaF + " " +
                Float.intBitsToFloat((signF << 31) | (expF + ((1 << 7) - 1)) << 23 | mantissaF));

        System.out.println(Double.MAX_VALUE + " Double");
        System.out.println(-Double.MAX_VALUE + " Double");
        long bits = Double.doubleToLongBits(-0.06);
        long sign = bits >>> 63;
        long exp = (bits >>> 52 & ((1 << 11) - 1)) - ((1 << 10) - 1);
        long mantissa = bits & ((1L << 52) - 1);
        System.out.println("double " + sign + " " + exp + " " + mantissa );
        System.out.println(Double.longBitsToDouble((sign << 63) | (exp + ((1 << 10) - 1)) << 52 | mantissa));

       {
             // при переполнении целочисленного числа следующим его значением будет MIN_VALUE.(в голову пришел вариант "считатьь на пальцах одной ладони" отгибая палец доходя до шести)
           int a = Integer.MAX_VALUE + 1;
           int b = Integer.MIN_VALUE;

           System.out.println(a == b);

       }
       {
            double a = Double.MAX_VALUE + 1;
            double b = Double.MAX_VALUE;
            double c = Double.MIN_VALUE; // *MIN_VALUE это то минимальное, отличное от нуля, число.
            double m = Double.MAX_VALUE + Integer.MAX_VALUE;
            double x = Double.MAX_VALUE * 2;
            System.out.println(a == b); // Результат теряется в процессе округления из - за величины самого числа.
            System.out.println(a == m); // Результат теряется в процессе округления из - за величины самого числа. При добавлении достаточно большого числа будет Double.POSITIVE_INFINITY
            System.out.println(x); // Слишком велик для представления, его значение становится бесконечным.
            System.out.println(c + 1); // *Если прибавить 1 то получится 1.0, отнять 1 то получится -1.0 (ну или -1.0000000000000000000000000000123 без округления)
       }

       {
            char a = 50; // char повышается до int ?
            int b = 'A'; //ASCII 'A' = 65
            System.out.println(a + b); //50 + 65
       }

       {
//           byte by = 42; //Автоматическое повышение операндов
//
//           char A = 'a';
//           short sh = 1024;
//           int in = 50000;
//           float fl = 5.67f;
//           double dl =.1234;
//           double result = (fl * by) + (in / A ) - (dl * sh);
//
//           System. out. println ((fl * by)+ " + "+ (in / A)+ " - " + (dl * sh));// (повышается до Float)+(повышается до Int)+(повышается до Double)
//           System. out. println ("result : " + result);

       }
    }
}


