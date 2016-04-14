public class Driver {

    public static void main (String[] args) {
	
	BetterMaze b = new BetterMaze("data3.dat");
	b.solveBFS();
	System.out.println(b.toString());
	System.out.println(b.solutionCoordinates());
    }

}
