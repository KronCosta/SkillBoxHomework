public class Main {

    public static void main(String[] args) {

        String text = "Our Founders Edition GeForce graphics cards feature excellent cooling and stunning designs that make your PC a striking showcase." +
                " For our new GeForce RTX 30 Series, we’ve created an innovative dual axial flow through cooling solution, featuring two fans - one at the left front," +
                " and another on the right rear that draws air through the card (the GeForce RTX 3070 flow through design differs slightly, with its fans both mounted on the top of the card).";

        String[] a = text.split("\\s");

        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i].replaceAll("[^a-zA-z]",""));
        }
    }
}


