import com.sun.source.tree.BreakTree;

import javax.xml.crypto.dom.DOMCryptoContext;

public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius)
    {
        double S = Math.PI * Math.abs(radius) * Math.abs(radius);
        //ну или
        // double S = Math.PI * Math.pow(radius,2);

        return S;
    }


    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius)
    {
        double diameter = radius * 2;

        //double V = Math.PI * (4.0 / 3.0) * Math.pow((double)diameter/2.0,3); или или
        double V = Math.PI * (4.0 / 3.0) * Math.pow(radius, 3);

        return V;
    }


    public static boolean isTriangleRightAngled(double a, double b, double c)
    {
        if(a < b + c && b < a + c && c < b + a)
        {
            System.out.println(" *Построение возможно* ");
            return true;
        }
        else
            {
            System.out.println( " -1.0 ");
            return false;
            }
    }
    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {

        if(isTriangleRightAngled(a, b, c )) {
            double p = (a + b + c) / 2;
            double p1 = (p - a);
            double p2 = (p - b);
            double p3 = (p - c);
            double pP = p * p1 * p2 * p3;
            double s = Math.sqrt(pP);
            return s;
        }
        return -1.0;


    }
}

