public class LNode {

    private int value;
    private LNode next;

    public LNode(int value, LNode next) {
	this.value = value;
	this.next = next;
    }

    public LNode(int value) {
	this(value, null);
    }

    public LNode(LNode next) {
        this(0, next);
    }

    public LNode() {
	this(0, null);
    }

    public int getValue() {
	return value;
    }

    public LNode getNext() {
	return next;
    }

    public int     setValue(int value) {
	int oldValue = value;
	this.value = value;
	return oldValue;
    }

    public LNode   setNext(LNode next) {
	LNode oldNext  = next;
	this.next = next;
	return oldNext;
    }

}
