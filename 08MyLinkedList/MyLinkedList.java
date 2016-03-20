public class MyLinkedList {

    private class LNode {
	
	private int value;
	private LNode next;
		
	public LNode(int value) {
	    this.value = value;
	}
	
	public int getValue() {
	    return value;
	}
	
	public LNode getNext() {
	    return next;
	}
	
	public int setValue(int value) {
	    int oldValue = value;
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
    private int size;
    
    public int get(int index) {
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

    public int set(int index, int newValue) {
	LNode current = head;
	int previousValue;
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

    public int remove(int index) {
	LNode current = head;
	int previousValue;
	for(int i = 0; i < index - 1; i++) {
	    current = current.getNext();
	}
	previousValue = current.getNext().getValue();
	current.setNext(current.getNext().getNext());
	return previousValue;
    }

    public boolean add(int index, int value) {
	LNode current = head;
	LNode newNode = new LNode(value);
	for(int i = 0; i < index - 1; i++) {
	    current = current.getNext();
	}
	newNode.setNext(current.getNext());
	current.setNext(newNode);
	return true;
    }
    
    public boolean add(int value) {
	if(head == null){
	    head = new LNode(value);
	}else{
	    LNode p = head;			
	    while(p.getNext()!=null){
		p = p.getNext();
	    }
	    p.setNext(new LNode(value));
	}
	size+=1;
	return true;
    }
    
    public int indexOf(int value) {
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

    public String toString() {
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
	MyLinkedList m = new MyLinkedList();
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
    }

}
