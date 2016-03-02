import java.util.Scanner;
import java.io.File;

public class Silver {

    private static char[][] field;
    private static int startRow;
    private static int startCol;
    private static int endRow;
    private static int endCol;
    private static int seconds;
    private static int possibleRoutes;
    private static boolean solved;

    private static void readInputFile(String inputFile) {

        int rows;
        int cols;

        try {

            File file = new File(inputFile);
            Scanner scan = new Scanner(file);
            String line;

            rows = scan.nextInt();
            cols = scan.nextInt();
            field = new char[rows][cols];

            seconds = scan.nextInt();

            scan.nextLine();

            // Stores elevations into field
            for (int row = 0; row < field.length; row++) {
                line = scan.nextLine();
                for (int col = 0; col < field[row].length; col++) {
                    field[row][col] = line.charAt(0);
                    line = line.substring(1, line.length());

                }
            }

            startRow = scan.nextInt() - 1;
            startCol = scan.nextInt() - 1;
            endRow = scan.nextInt() - 1;
            endCol = scan.nextInt() - 1;

        } catch (Exception e) {
            return;
        }


    }

    public static void solve(int row, int col, int steps) {
        if (steps > seconds) {
            return;
        } else if (row < 0 || col < 0 || row >= field.length || col >= field[0].length) {
            return;
        } else if (field[row][col] == '*') {
            return;
         }
        if (row == endRow && col == endCol && steps == seconds) {
            possibleRoutes++;
            return;
        } else {
            solve(row + 1 , col, steps + 1);
            solve(row - 1 , col, steps + 1);
            solve(row, col + 1, steps + 1);
            solve(row, col - 1, steps + 1);
        }
    }

    public static void printField() {

        for (int row = 0; row < field.length; row++) {
            System.out.println();
            System.out.println();
            for (int col = 0; col < field[row].length; col++) {
                char fieldValue = field[row][col];
                System.out.print(" " + fieldValue);
            }
        }

        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        readInputFile("ctravel.in");
        solve(startRow, startCol, 0);
        System.out.println("" + possibleRoutes + ",7,Zeng,Anthony");
    }

}