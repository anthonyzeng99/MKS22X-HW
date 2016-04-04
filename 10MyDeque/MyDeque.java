import java.util.Arrays;

public class MyDeque<T> {

    
    private T[] deque;
    private int start, end, size;

    @SuppressWarnings("unchecked")
    public MyDeque() {
	deque = (T []) new Object[8];
    }

    public void addFirst(T value) {
	if (size == 0) {  
	    start = deque.length - 1;
	    deque[start] = value;
	    size++;
	} else if (start == end) {
	    grow();
	    addFirst(value);
	} else {
	    start--;
	    deque[start] = value;
	    size++;
	}
    }

    public void addLast(T value) {
	if (size == 0) {
	    end = 0;
	    deque[deque.length - 1] = value;
	    size++;
	} else if (start == end) {
	    grow();
	    addLast(value);
	} else {
	    end++;
	    deque[end - 1] = value;
	    size++;
	}
    }

    
    public T removeFirst() {
	if (start < deque.length - 1) {
	    size--;
	    start++;
	    return deque[start - 1];
	} else {
	    size--;
	    start = 0;
	    return deque[deque.length - 1];
	}
    }
    
    
    
    public T removeLast() {
	if (end == 0) {
	    end = deque.length - 1;
	    size--;
	    return deque[deque.length - 1];
	}  else {
	    end--;
	    size--;
	    return deque[end];
	}
    }
    

    public T getFirst() {
	return deque[start];
    }

    public T getLast() {
	return deque[end];
    }

    @SuppressWarnings("unchecked")
    private void grow() {
	T[] newArray = Arrays.copyOf(deque, deque.length * 2);
	this.deque = newArray; 
    }

}