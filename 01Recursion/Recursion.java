public class Recursion implements hw01 {


    public Recursion() {

    }


    public String name() {
	return "Zeng,Anthony";
    }

    
    public double sqrt(double n) {
	double guess;
	guess = 1.0;
	if ( n < 0 ) {
	    throw new IllegalArgumentException();
	} 
	return calculateGuess(n,guess);
	
    }

    public double calculateGuess(double n, double guess) {
	double newGuess = ( ( n / guess ) + guess ) / 2.0;
	if ( percentDifference(guess,newGuess) < 0.1 || newGuess == 0) {
	    return newGuess;
	} else {
	    return calculateGuess(n, newGuess);
	}
    }

    public double percentDifference(double x, double y) {
	double difference;
	double average;
	difference = x - y;
	average = (x + y) / 2.0;
	return Math.abs(difference / average) * 100.0;
    }

}