public class QueenBoard {

    private int[][] gameBoard;


    public QueenBoard() {
	gameBoard = new int[4][4];
    }


    public QueenBoard(int size) {
	gameBoard = new int[size][size];
    }


    public boolean addQueen(int row, int col) {
	if ( gameBoard[row][col] != 0 ) {
	    return false;
	}
	int nextCol = 1;
        gameBoard[row][col] = 1;
        while ((nextCol + col) < gameBoard[row].length) {
            gameBoard[row][col + nextCol]--;
            if ((row + nextCol) < gameBoard.length) {
                gameBoard[row + nextCol][col + nextCol]--;
            }
            if ((row - nextCol) >= 0) {
                gameBoard[row - nextCol][col + nextCol]--;
            }
            nextCol++;
        }
	return true;
    }

    public boolean removeQueen(int row, int col) {
	if ( gameBoard[row][col] != 1 ) {
	    return false;
	}
	int nextCol = 1;
        gameBoard[row][col] = 0;
        while ((nextCol + col) < gameBoard[row].length) {
            gameBoard[row][col + nextCol]++;
            if ((row + nextCol) < gameBoard.length) {
                gameBoard[row + nextCol][col + nextCol]++;
            }
            if ((row - nextCol) >= 0) {
                gameBoard[row - nextCol][col + nextCol]++;
            }
            nextCol++;
        }
	return true;
    }

    public boolean solve() {
	return solveH(0);
    }

    private boolean solveH(int col) {
	if(col>=gameBoard.length){
	    return true;
	}
	for(int row = 0; row < gameBoard.length; row++){
	    if (addQueen(row,col)){
		if (solveH(col+1)){
		    return true;
		}else{
		    removeQueen(row,col);
		}
	    }
		}
	return false;
    }

    public void printSolution() {
	for ( int rowIndex = 0; rowIndex < gameBoard.length; rowIndex++ ) {
	    System.out.println();
	    System.out.println();
	    for ( int colIndex = 0; colIndex < gameBoard[0].length; colIndex++ ) {
		if (gameBoard[rowIndex][colIndex] == 1) {
		    System.out.print("  Q");
		} else {
		    System.out.print("  _");
		}
	    }
	}
	System.out.println();
	System.out.println();
    }


    public static void main(String[] args) {
	
	QueenBoard b1 = new QueenBoard(32);

	System.out.println(b1.solve());
	b1.printSolution();

    }
}
