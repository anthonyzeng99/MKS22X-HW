public class KnightBoard {

    public static final boolean DEBUG = false;
    public int[][] board;
    public int boardSize;
    public int border = 2;
    public int knights = 0;

    public KnightBoard(int n) {
	boardSize = n;
	board = new int[n + (2 * border)][n + (2 * border)];
	for ( int row = 0; row < board.length; row++ ) {
	    for ( int col = 0; col < board[row].length; col++ ) {
		if ( isBorder(row,col) ) {
		    board[row][col] = -1;
		} else {
		    board[row][col] = 0;
		}
	    }
	}
    }


    private boolean isBorder(int row, int col) {
	if ( row < border || row >= ( border + boardSize ) ) {
	    return true;
	}  else if ( col < border || col >= ( border + boardSize)  ) {
	    return true;
	} 
	return false;
    }


    public boolean solve() {
	for (int i = 0; i < boardSize + border; i++) {
	    if (solveH(border+i,border)) {
		return true;
	    }
	}
	return false;
    }


    private boolean solveH(int row, int col) {
	knights++;
	if (knights > boardSize * boardSize) {
	    return true;
	} else if (board[row][col] != 0) {
	    knights--;
	    return false;
	} else {
	    board[row][col] = knights;
	    if ( solveH(row - 1 , col + 2) ||
		 solveH(row - 1 , col - 2) ||
		 solveH(row + 1 , col + 2) ||
		 solveH(row + 1 , col - 2) ||
		 solveH(row + 2 , col + 1) ||
		 solveH(row + 2 , col - 1) ||
		 solveH(row - 2 , col + 1) ||
		 solveH(row - 2 , col - 1)) {
		return true;
	    } else {
		board[row][col] = 0;
		knights--;
	    }

	}
	return false;
    }



    public void printSolution() {

        int printStart;
	int printStop;

	if (DEBUG) {
	    printStart = 0;
	    printStop = board.length;
	} else {
	    printStart = border;
	    printStop = ( boardSize + border);
	}

	for ( int row = printStart; row < printStop; row++ ) {
	    System.out.println();
	    System.out.println();
	    for ( int col = printStart; col < printStop; col++ ) {
		int boardValue = board[row][col];
		if (boardValue < 0 || boardValue >= 10) {
		    System.out.print("  " + Integer.toString(boardValue));
		} else {
		System.out.print("   " + Integer.toString(boardValue));
		}
	    }
	}

	System.out.println();
	System.out.println();
    }
    
    
    public static void main(String[] args) {
	
	KnightBoard k = new KnightBoard(6);
        System.out.println(k.solve());
	k.printSolution();

    } 


}
