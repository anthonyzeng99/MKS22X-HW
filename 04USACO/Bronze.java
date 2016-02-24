import java.util.Scanner;
import java.io.File;

public class Bronze {

    private static int[][] field;
    private static int[][] instructions;
    private static int elevation;
    
    private static void readInputFile(String inputFile) {
	int rows;
	int cols;
	int numInstructions;

	try {
	
	    File file = new File(inputFile);
	    Scanner scan = new Scanner(file);
	    Scanner line;

	    rows = scan.nextInt();
	    cols = scan.nextInt();
	    field = new int[rows][cols];

	    elevation = scan.nextInt();
	    numInstructions = scan.nextInt();
	    instructions = new int[numInstructions][3];
	    scan.nextLine();
	    
	    // Stores elevations into field
	    for (int row = 0; row < field.length; row++) {
		line = new Scanner(scan.nextLine());
		for (int col = 0; col < field[row].length; col++) {
		    field[row][col] = line.nextInt();
		}
	    }

	    // Stores instruction
	    for (int row = 0; row < numInstructions; row++) {
		line = new Scanner(scan.nextLine());
		for (int col = 0; col < 3; col++) {
		    instructions[row][col] = line.nextInt(); 
		}
	    }

	    
	    
	} catch (Exception e) {
	    return;
	}
	
    }

    private static void stomp() {
	int row_s;
	int col_s;
	int depthToDig;
	int maxElevation;
	
	for (int instruction = 0; instruction  < instructions.length; instruction++ ) {
	    
	    row_s = instructions[instruction][0] - 1;
	    col_s = instructions[instruction][1] - 1;
	    depthToDig = instructions[instruction][2];
	    maxElevation = maxGridElevation(row_s, col_s);

	    for (int i = row_s; i < row_s + 3; i++) {
		for (int j = col_s; j < col_s + 3; j++) {
		    if (field[i][j] >= maxElevation - depthToDig) {
			field[i][j] = maxElevation - depthToDig;
		    }

		}
	    }
	}

    }

    private static int maxGridElevation(int row, int col) {
	int maxElevation = 0;
	for (int i = row; i < row + 3; i++) {
	    for (int j = col; j < col + 3; j++) {
		if (field[i][j] > maxElevation) {
		    maxElevation = field[i][j];
		}
	    }
	}
	return maxElevation;
    }

    private static int lakeVolume() {

	final int squareFeetPerBox = 5184;
	int aggregateDepth = 0;
	for (int row = 0; row < field.length; row++) {
	    for (int col = 0; col < field[row].length; col++) {
		if (elevation - field[row][col] > 0) {
		    aggregateDepth += (elevation - field[row][col]);
		}
		
	    }
	}
	return aggregateDepth * squareFeetPerBox;
    }


    public static void printField() {

        for ( int row = 0; row < field.length; row++ ) {
            System.out.println();
            System.out.println();
            for ( int col = 0; col < field[row].length; col++ ) {
                int fieldValue = field[row][col];
                if (fieldValue < 0 || fieldValue >= 10) {
                    System.out.print("  " + Integer.toString(fieldValue));
                } else {
		    System.out.print("   " + Integer.toString(fieldValue));
                }
            }
        }

        System.out.println();
        System.out.println();
    }

    public static void printInstructions() {
        for ( int row = 0; row < instructions.length; row++ ) {
            System.out.println();
            System.out.println();
            for ( int col = 0; col < instructions[row].length; col++ ) {
                System.out.print( instructions[row][col] + " ");
            }
        }

        System.out.println();
        System.out.println();
    }


    
    public static void main(String[] args) {
	readInputFile("makelake.in");
	stomp();
	System.out.println("" + lakeVolume() + ", 7, Zeng, Anthony");        
    }


}
