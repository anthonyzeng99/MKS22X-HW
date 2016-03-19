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
	return 0;
    }

    public int size() {
	return size;
    }

    public int remove(int index) {
	return 0;
    }

    public boolean add(int index, int value) {
	return false;
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
	return 0;
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
    }

}
