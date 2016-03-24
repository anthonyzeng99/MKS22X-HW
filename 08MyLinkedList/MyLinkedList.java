import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

    public Iterator<T> iterator() {
	return new X();
    }

    public class X implements Iterator<T> {

	public boolean hasNext() {
	    return true;
	}

	public T next() {
	    return head.getValue();
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}
	
    }

    private class LNode {
	
	private T value;
	private LNode next;
		
	public LNode(T value) {
	    this.value = value;
	}
	
	public T getValue() {
	    return value;
	}
	
	public LNode getNext() {
	    return next;
	}
	
	public T setValue(T value) {
	    T oldValue = value;
	    this.value = value;
	    return oldValue;
	}
	
	public LNode setNext(LNode next) {
	    LNode oldNext  = next;
	    this.next = next;
	    return oldNext;
	}
	
    }
    
    private LNode head;
    private LNode tail;
    private int size;
    
    public T get(int index) {
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	for (int i = 0; i < index; i++) {
	    if (current.getNext() != null) {
		current = current.getNext();
	    } else {
		throw new IndexOutOfBoundsException();
	    }
	}
	return current.getValue();
    }

    public T set(int index, T newValue) {
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	T previousValue;
	for (int i = 0; i < index; i++) {
	    if (current.getNext() != null) {
		current = current.getNext();
	    } else {
		throw new IndexOutOfBoundsException();
	    }
	} 
	previousValue = current.getValue();
	current.setValue(newValue);
	return previousValue;
    }

    public int size() {
	LNode current = head;
	int len = 0;
	while (current.getNext() != null) {
	    len++;
	    current = current.getNext();
	}
	return len + 1;
    }

    public T remove(int index) {
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	T previousValue;
	for(int i = 0; i < index - 1; i++) {
		current = current.getNext();
	}
	previousValue = current.getNext().getValue();
	current.setNext(current.getNext().getNext());
	size--;
	return previousValue;
    }

    public boolean add(int index, T value) {	
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	LNode newNode = new LNode(value);
	for(int i = 0; i < index - 1; i++) {
	    current = current.getNext();
	}
	newNode.setNext(current.getNext());
	current.setNext(newNode);
	if (index == 0) {
	    head = newNode;
	} else if (index == size) {
	    tail = newNode;
	}
	size++;
	return true;
    }
    
    public boolean add(T value) {
	if(head == null){
	    head = new LNode(value);
	}else{
	    LNode p = head;			
	    while(p.getNext()!=null){
		p = p.getNext();
	    }
	    LNode newNode = new LNode(value);
	    tail = newNode;
	    p.setNext(newNode);
	}
	size+=1;
	return true;
    }
    
    public int indexOf(T value) {
	LNode current = head;
	int index = 0;
	while (current.getNext() != null) {
	    if (current.getValue() == value) {
		return index;
	    }
	    current = current.getNext();
	    index++;
	}
	if (current.getValue() == value) {
	    return index;
	} 
	return -1;

    }

    public String toString(boolean bool) {
	String ans = "[";
	LNode p = head;
	while(p != null){
	    ans += p.getValue();
	    if(p.getNext()!= null){
		ans+=", ";
	    }
	    p = p.getNext();
	}
	return ans+"]";	
    }

    public static void main(String[] args) {
	MyLinkedList<String>  m = new MyLinkedList<String>();
	/*
	System.out.println(m);
	m.add(3);
	m.add(-3);
	m.add(0);
	System.out.println(m);
	m.set(1,2);
	System.out.println(m);
	System.out.println(m.get(0));
	System.out.println(m.get(1));
	m.add(7);
	m.add(7);
	m.add(6);
	System.out.println(m);
	System.out.println(m.indexOf(6));
	System.out.println(m.indexOf(8));
	m.remove(2);
	System.out.println(m);
	m.add(3, 23);
	System.out.println(m);
	System.out.println(m.size());
	m.add(42);
	System.out.println(m.size());
	*/
	m.add("hi");
	m.add("hello");
	m.add("goodbye");
	System.out.println(m);
	m.add(2,"no");
	System.out.println(m);
	m.set(0,"good morning");
	m.remove(3);
	System.out.println(m);
	System.out.println(m.get(1));
	System.out.println(m.indexOf("no"));
    }   
}
