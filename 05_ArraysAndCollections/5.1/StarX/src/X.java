import java.io.IOException;

public class X {

    public static void main(String[] args) throws IOException {
        int len = 8;
        char startLetter = 'A';
        String[][] chess = new String[len][len];
        for (int i = 0; i < len; i++) {
            char letter = startLetter;
            for (int j = 0; j < len; j++, letter++) {
                chess[i][j] = "" + letter + (i + 1);
            }
        }printArray(chess);
        for (int i = 0; i < chess.length / 2; ++i) {
            String[] tmp = chess[i];//переменная для сохранения прошлого значения "i"
            chess[i] = chess[chess.length - 1 - i];
            chess[chess.length - 1 - i] = tmp;
        }



        printArray(chess);
    }

    public static void printArray(String[][] c) { //метод печати массива
        for (String[] s : c) {
            for (String st : s) {
                System.out.print(st + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
//        Scanner scanner = new Scanner(System.in);

//        int number = 8;

//        String[] abc = {"A", "B", "C", "D", "E", "F", "J", "H"};
//        String[][] iks = new String[number + 1][number];
//
//        for (int x = 0; x < iks.length; x++) {
//            for (int y = 0; y < iks[x].length; y++) {
//                for (int j = 0; j < abc.length; j++) {
//                    for (int i = 8; i >= 1; i--) {
//                        iks[y][x] = String.valueOf(i + abc[j]);
//
//                    }
//                }
//            }
////            System.out.println(Arrays.toString(iks[x]));
//        }
//        for (int i = 0; i < iks.length / 2; ++i) {
//            String[] tmp = iks[i];//переменная для сохранения прошлого значения "i"
//            iks[i] = iks[iks.length - 1 - i];
//            iks[iks.length - 1 - i] = tmp;
//        }
//        System.out.print(Arrays.toString(iks));





//        for(int i = 1; i < iks.length; i++){
//            for(int j = 0; j < iks[0].length; j ++) {
//                if ((i + j) % number != 0 && i - j != 1)
//                    iks[i][j] = " " ;
//                else iks[i][j] = "x";
//        for(int i = 1; i < iks.length; i++){
//            for(int j = 0; j < iks[0].length; j ++) {
//                if ((i + j) % 2 != 0)// && i - j != 1)
//                    iks[i][j] = "W" ;
//                else iks[i][j] = "B";
//
//            }



