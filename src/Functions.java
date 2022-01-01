public class Functions extends Colors2048{

    public static int score = 0;

    public static String[] colorsForNumbers = new String[]{ANSI_WHITE, ANSI_CYAN, ANSI_GREEN, ANSI_BLUE, ANSI_PURPLE, ANSI_RED, ANSI_WHITE_BACKGROUND, ANSI_CYAN_BACKGROUND, ANSI_GREEN_BACKGROUND, ANSI_BLUE_BACKGROUND, ANSI_PURPLE_BACKGROUND, ANSI_RED_BACKGROUND};

    private static int[] getVertical(int[][] a, int point) {

        int[] arr = new int[a.length];

        for (int i = 0; i < a.length; i++) {

            arr[i] = a[i][point];
        }

        return arr;

    }

    private static int[] getHorizontal(int[][] a, int point) {

        int[] arr;

        arr = a[point];

        return arr;

    }

    public static int[][] move(int[][] a, int num) {

        // num - walk command

        int[] randomNum = new int[]{2, 4, 8};

        int[] arr;

        if (num == 2) {

            for (int i = 0; i < a.length; i++) {

                int[] sumStack = getVertical(a, i);

                sumStack = sortRight(sumStack);

                for (int j = 1; j < sumStack.length; j++) {


                    if (sumStack[j - 1] == sumStack[j]) {

                        sumStack[j - 1] = 0;
                        sumStack[j] *= 2;

                        score += sumStack[j - 1];

                    }

                    a[j][i] = sumStack[j];

                }


            }


            int randomCellX = 0;

            int randomCellY = a.length - 1;

            int x = (int) (randomCellX + Math.random() * randomCellY);
            int y = (int) (randomCellX + Math.random() * randomCellY);

            if (a[x][y] == 0) {

                a[x][y] = 2;

            }

        }

        if (num == 8) {

            for (int i = a.length - 1; i >= 0; i--) {

                int[] sumStack = getVertical(a, i);

                sumStack = sortLeft(sumStack);

                for (int j = 0; j < sumStack.length - 1; j++) {


                    if (sumStack[j + 1] == sumStack[j]) {

                        sumStack[j + 1] = 0;
                        sumStack[j] *= 2;

                        score += sumStack[j];

                    }

                    a[j][i] = sumStack[j];

                }


            }


            int randomCellX = 0;

            int randomCellY = a.length - 1;

            int x = (int) (randomCellX + Math.random() * randomCellY);
            int y = (int) (randomCellX + Math.random() * randomCellY);

            if (a[x][y] == 0) {

                a[x][y] = randomNum[(int) (0 + Math.random() * 3)];

            }

        }

        if (num == 4) {


            for (int i = 0; i < a.length; i++) {

                int[] sumStack = getHorizontal(a, i);

                sumStack = sortLeft(sumStack);

                for (int j = a.length - 2; j >= 0; j--) {

                    if (sumStack[j + 1] == sumStack[j]) {

                        sumStack[j] = 0;
                        sumStack[j + 1] *= 2;

                        score += sumStack[j + 1];
                    }


                }

                a[i] = sumStack;

            }

            int randomCellX = 0;

            int randomCellY = a.length - 1;

            int x = (int) (randomCellX + Math.random() * randomCellY);
            int y = (int) (randomCellX + Math.random() * randomCellY);

            if (a[x][y] == 0) {

                a[x][y] = 2;

            }

        }

        if (num == 6) {


            for (int i = 0; i < a.length; i++) {

                int[] sumStack = getHorizontal(a, i);

                sumStack = sortRight(sumStack);

                for (int j = 0; j < a.length - 1; j++) {

                    if (sumStack[j + 1] == sumStack[j]) {

                        sumStack[j] = 0;
                        sumStack[j + 1] *= 2;

                        score += sumStack[j + 1];

                    }


                }

                a[i] = sumStack;

            }

            int randomCellX = 0;

            int randomCellY = a.length - 1;

            int x = (int) (randomCellX + Math.random() * randomCellY);
            int y = (int) (randomCellX + Math.random() * randomCellY);

            if (a[x][y] == 0) {

                a[x][y] = 2;

            }

        }

        return a;

    }

    private static int[] sortRight(int[] arr) {

        int count1 = 0;

        int n = arr.length;

        for (int i = 0; i < n; i++)

            if (arr[i] != 1)

                arr[count1++] = arr[i];

        while (count1 < n)

            arr[count1++] = 1;

        int lastNonOne = 0;

        for (int i = n - 1; i >= 0; i--) {


            if (arr[i] == 1)

                continue;

            if (lastNonOne == 0) {


                lastNonOne = i;

            }

            if (arr[i] != 0)

                arr[lastNonOne--] = arr[i];


        }

        while (lastNonOne >= 0) {

            arr[lastNonOne--] = 0;

        }

        return arr;

    }

    private static int[] sortLeft(int[] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0)

                arr[count++] = arr[i];

        }

        while (count < arr.length) {

            arr[count++] = 0;
        }

        return arr;

    }

    public static void outputMatrix(int[][] a) {

        System.out.println();
        System.out.println();
        String s = ANSI_BLACK + "^.^SCORE^.^" + ANSI_RESET;
        System.out.println(ANSI_WHITE_BACKGROUND + s + ANSI_RESET);


        if ((score+"").length() == 1){

            System.out.println(ANSI_CYAN + "#######" + "\n" +
                    "#" + score + "----#" + "\n" +
                    "#######" + ANSI_RESET
            );

        }
        if ((score+"").length() == 2){

            System.out.println(ANSI_GREEN + "#######" + "\n" +
                    "#" + score + "---#" + "\n" +
                    "#######" + ANSI_RESET
            );

        }
        if ((score+"").length() == 3){

            System.out.println(ANSI_BLUE + "#######" + "\n" +
                    "#" + score + "--#" + "\n" +
                    "#######" + ANSI_RESET
            );

        }
        if ((score+"").length() == 4){

            System.out.println(ANSI_PURPLE + "#######" + "\n" +
                    "#" + score + "-#" + "\n" +
                    "#######" + ANSI_RESET
            );

        }
        if ((score+"").length() == 5){

            System.out.println(ANSI_RED + "#######" + "\n" +
                    "#" + score + "#" + "\n" +
                    "#######" + ANSI_RESET
            );

        }

        for (int i = 0; i < a.length; i++) {

            System.out.println();
            System.out.println();

            for (int j = 0; j < a.length; j++) {

                if ((a[i][j] + "").length() == 1){

                    System.out.print(colorsForNumbers[(int)Math.pow(a[i][j], 0.5)] + a[i][j] + ANSI_RESET + "    ");

                }
                if ((a[i][j] + "").length() == 2){

                    System.out.print(colorsForNumbers[(int)Math.pow(a[i][j], 0.5) + 1] + a[i][j] + ANSI_RESET + "   ");

                }
                if ((a[i][j] + "").length() == 3){

                    System.out.print(colorsForNumbers[(int)Math.pow(a[i][j], 0.5) + 1] + a[i][j] + ANSI_RESET + "  ");

                }
                if ((a[i][j] + "").length() == 4){

                    System.out.print(colorsForNumbers[(int)Math.pow(a[i][j], 0.5) + 1] + a[i][j] + ANSI_RESET + " ");

                }


            }

        }

    }

    public static boolean isGameRunning(int[][] a){

        int cellCount = a.length * a.length;
        int c = 0;

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length; j++) {

                if (a[i][j] != 0){

                    c ++;

                }

            }

        }

        return cellCount != c;

    }

    public static boolean check(int[][] a){

        boolean found2048 = false;

        if (!isGameRunning(a)){

            for (int i = 0; i < a.length; i++) {

                for (int j = 0; j < a.length; j++) {

                    if (a[i][j] == 2048){

                        return true;

                    }

                }

            }

        }
        return false;
    }

}
