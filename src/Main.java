import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] matrix = new int[5][5];

        System.out.println("Use keys: " + "\n" +
                "% ------||------ %" + "\n" + "\n" +
                "|->   8 to UP" + "\n" +  "\n" +
                "|->  4 to LEFT" + "\n" + "\n" +
                "|->  2 to DOWN" + "\n" + "\n" +
                "|->  6 to RIGHT" + "\n" + "\n" +
                "% ------||------ %"
        );

        int in;

        while (true){

            Functions.outputMatrix(matrix);

            in = sc.nextInt();

            Functions.move(matrix, in);


        }

    }



}
