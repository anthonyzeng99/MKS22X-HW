public class KnightBoard {

    public int[][] board;
    public int border = 2;

    public KnightBoard(int n) {
	board = new int[n + border][n + border];
	for ( int row = 0; row < board.length; row++ ) {
	    for ( int col = 0; col < board[rowIndex].length; col++ ) {
		if ( (row >= border && row <= board.length - border) && (col >= border && col <= board[row].length) ) {
		    board[row][col] = -1;
		}
	    }
	}
    }


    public isBorder(int row, int col) {

    }

}
