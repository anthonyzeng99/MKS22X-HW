public class RunningMedian {

    private MyHeap<Integer> smaller;
    private MyHeap<Integer> larger;

    public RunningMedian() {
	smaller = new MyHeap<Integer>(true);
	larger = new MyHeap<Integer>();
    }

    public double getMedian() {
	if (smaller.getSize() > larger.getSize()) {
	    return smaller.peek();
	} else if (larger.getSize() > smaller.getSize()) {
	    return larger.peek();
	}
	return (smaller.peek() + larger.peek()) / 2;
    }

    public void add(Integer x) {
	
    }

    public static void main(String[] args) {
	RunningMedian m = new RunningMedian();
	
    }

}
