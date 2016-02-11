public class Board {

    private int[][] gameBoard;


    public Board() {
	gameBoard = new int[4][4];
    }


    public Board(int size) {
	gameBoard = new int[size][size];
    }


    public boolean addQueen(int row, int col) {
	if (gameBoard[row][col] != 0) {
	    return false;
	}
	int nextCol = 1;
	gameBoard[row][col] = 1;
	while ((nextCol + col) < gameBoard[0].length) {
	     gameBoard[row][col + nextCol]--;
	    if ((col + nextCol) < gameBoard[0].length) {
		gameBoard[row + nextCol][col + nextCol]--;
	    }
	    if ((col - nextCol) >= 0) {
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
        while ((nextCol + col) < gameBoard[0].length) {
            gameBoard[row][col + nextCol]++;
            if ((col + nextCol) < gameBoard[0].length) {
                gameBoard[row + nextCol][col + nextCol]++;
            }
            if ((col - nextCol) >= 0) {
                gameBoard[row - nextCol][col + nextCol]++;
            }
            nextCol++;
        }
	return true;
    }

    public boolean solve() {
	for ( int colIndex = 0; colIndex > gameBoard[0].length; colIndex++ ) {
	    solveH(0,colIndex);
	}
	return false;
    }

    private boolean solveH(int row, int col) {
	int nextRow;
	if ( row >= gameBoard.length) {
	    return false;
	} else if ( addQueen(row,col) ) {
	    return true;
	} else {
	    nextRow = row + 1;
	    removeQueen(row,col);
	    return solveH(nextRow,col);
	}
    }

    public void printBoard() {
	for ( int rowIndex = 0; rowIndex < gameBoard.length; rowIndex++ ) {
	    System.out.println();
	    System.out.println();
	    for ( int colIndex = 0; colIndex < gameBoard[0].length; colIndex++ ) {
		System.out.print( Integer.toString(gameBoard[rowIndex][colIndex]) + "  "  );
	    }
	}
	System.out.println();
	System.out.println();
    }


    public static void main(String[] args) {
	
	Board b1 = new Board(4);

	b1.printBoard();
	b1.solve();
      	b1.printBoard();
    }
}
