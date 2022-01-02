import java.util.Scanner;

public class Main extends Colors2048 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] matrix = new int[5][5];



        System.out.println(ANSI_GREEN + "Use keys: " + "\n" +
                "% ------||------ %" + "\n" + "\n" +
                "|->   8 to UP" + "\n" +  "\n" +
                "|->  4 to LEFT" + "\n" + "\n" +
                "|->  2 to DOWN" + "\n" + "\n" +
                "|->  6 to RIGHT" + "\n" + "\n" +
                "% ------||------ %" + ANSI_RESET
        );

        int in;

        while (true){

            Functions.outputMatrix(matrix);

            in = sc.nextInt();

            Functions.move(matrix, in);

            if (!Functions.isGameRunning(matrix)){

                if (Functions.check(matrix)){

                    System.out.println(ANSI_CYAN + "^.^^^^^^You Win^^^^^^.^" + ANSI_RESET);

                }else {

                    System.out.println(ANSI_RED + "<<<<<<<<You Lose>>>>>>>>" + ANSI_RESET);

                }

                break;

            }

        }

    }



}
