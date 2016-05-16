import java.util.*;

public class RunningMedian {

    private MyHeap<Integer> smaller;
    private MyHeap<Integer> larger;
    private int smallSize;
    private int largeSize;
    private int median;

    public RunningMedian() {
	smaller = new MyHeap<Integer>(true);
	larger = new MyHeap<Integer>();
    }

    public double getMedian() {
	if (smallSize == 0 && largeSize == 0) {
	    throw new NoSuchElementException();
	}
	return median;
    }

    public void add(Integer x) {
	if (smallSize == 0 && largeSize == 0) {
	    smaller.add(x);
	    smallSize++;
	    median = x;
	    
	} else {
	    if (x < median) {
		smaller.add(x);
		smallSize++;
	    } else {
		larger.add(x);
		largeSize++;
	    }
	}

	if (Math.abs(largeSize - smallSize) > 1) {
	    if (largeSize > smallSize) {
		for (int i = (largeSize - smallSize) / 2; i > 0; i++) {
		    int temp = larger.delete();
		    smaller.add(temp);
		    largeSize--;
		    smallSize++;
		    
		}
	    } else {
		for (int i = (smallSize - largeSize) / 2; i > 0; i++) {
		    int temp = smaller.delete();
		    larger.add(temp);
		    smallSize--;
		    largeSize++;
		}
	    }
	}
    }

    public static void main(String[] args) {
	RunningMedian m = new RunningMedian();
	
    }

}
