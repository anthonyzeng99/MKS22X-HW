public class Board {

    private int[][] gameBoard;


    public Board() {
	gameBoard = new int[4][4];
    }


    public Board(int size) {
	gameBoard = new int[size][size];
    }


    public void addQueen(int row, int col) {
	int nextCol = 1;
	gameBoard[row][col] = 1;
	for (int colIndex = col + nextCol; colIndex < gameBoard[0].length; colIndex++) {
	    gameBoard[row][colIndex]--;
	}
	while ((nextCol + col) < gameBoard[0].length) {
	    if ((col + nextCol) < gameBoard[0].length) {
		gameBoard[row + nextCol][col + nextCol]--;
	    }
	    if ((col - nextCol) >= 0) {
		gameBoard[row - nextCol][col + nextCol]--;
	    }
	    nextCol++;
	}
	
	
    }

    public void removeQueen(int row, int col) {
	int nextCol = 1;
        gameBoard[row][col] = 0;
        for (int colIndex = col + nextCol; colIndex < gameBoard[0].length; colIndex++) {
            gameBoard[row][colIndex]++;
        }
        while ((nextCol + col) < gameBoard[0].length) {
            if ((col + nextCol) < gameBoard[0].length) {
                gameBoard[row + nextCol][col + nextCol]++;
            }
            if ((col - nextCol) >= 0) {
                gameBoard[row - nextCol][col + nextCol]++;
            }
            nextCol++;
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
	
	Board b1 = new Board(6);

	b1.printBoard();
	b1.addQueen(2,2);
	b1.printBoard();
	b1.removeQueen(2,2);
	b1.printBoard();
    }
}