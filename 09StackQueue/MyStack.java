public class MyStack<T> {

    private MyLinkedList<T> stack;

    public MyStack() {
	stack = new MyLinkedList<T>();
    }

    /**
     * Adds the given item to the top of the stack.
     */
    public void push(T item) {
	stack.add(0, item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop() {
	return stack.remove(0);
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek() {
	return stack.get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    public int size() {
	return stack.size();
    } 

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty() {
	return size() == 0;
    }

}