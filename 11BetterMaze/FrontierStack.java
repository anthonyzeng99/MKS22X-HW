import java.util.*;

public class FrontierStack<T> implements Frontier<T> {
    
    private Stack<T> stack;

    public FrontierStack() {
	stack = new Stack<T>();
    }

    public void add(T element) {
	stack.push(element);
    }

    public T next() {
	if (stack.isEmpty()) {
	    throw new NoSuchElementException();
	}
	return stack.pop();
    }

    public boolean hasNext() {
	return !stack.isEmpty();
    }

}