import java.util.*;

public class FrontierQueue<T> implements Frontier<T> {

    private ArrayDeque<T> queue;

    public FrontierQueue() {
	queue = new ArrayDeque<T>();
    }

    public void add(T element) {
	queue.addLast(element);
    }

    public T next() {
	if (queue.isEmpty()) {
	    throw new NoSuchElementException();
	}
	return queue.removeFirst();
    }

    public boolean hasNext() {
	return !queue.isEmpty();
    }

}