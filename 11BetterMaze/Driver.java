public class Driver {

    public static void main (String[] args) {
	
	BetterMaze b = new BetterMaze("data1.dat");
	b.solveBFS();
	System.out.println(b.toString());
    }

}
