public class BSTree<T extends Comparable<T>> {

    private class Node {
	T data;
	Node left;
	Node right;

	public Node(T data) {
	    this.data = data;
	}

	public void setData(T data) {this.data = data;}
	public void setLeft(Node left) {this.left = left;}
	public void setRight(Node right) {this.right = right;}

	public T getData() {return data;}
	public Node getLeft() {return left;}
	public Node getRight() {return right;}

	public int height() {
	    return 0;
	}

	public void add(T value) {
	    add(root,value);
	}

	public void add(Node current, T value) {
	    boolean added = false;
	    while ( !added ) {
		if ( value.compareTo(current.data) < 0 ) {
		    if (current.left == null ) {
			current.left = new Node(value);
			added = true;
			System.out.println("added left");
		    } else { 
			System.out.println("<");
			add(current.left,value);
		    }		    
		} else if ( value.compareTo(current.data) > 0 ) {
		    if (current.right == null) {
			current.right = new Node(value);
			added = true;
			System.out.println("added right");
		    } else {
			System.out.println(">");
			add(current.right,value);
		    }
		}	
	    }
	}

	public String toString() {
	    return "";
	}

	public boolean contains(T value) {
	    return false;
	}

    }

    private Node root;

    public BSTree(T data) {
	root = new Node(data);
    }

    public void add(T value) {
	root.add(value);
    }

    public String toString() {
	return root.toString();
    }

    public boolean contains(T value) {
	return root.contains(value);
    }

    public int getHeight() {
	return root.height();
    }

    public static void main(String[] args) {
	BSTree<Integer> tree = new BSTree<Integer>(5);
	tree.add(6);
	tree.add(2);
	tree.add(3);
	tree.add(12);
	tree.add(72);
	tree.add(91);
	tree.add(32);
	tree.add(8);
	tree.add(0);
	tree.add(38);
	tree.add(23);
	tree.add(26);
	tree.add(13);
	tree.add(18);
	tree.add(62);
	tree.add(85);
    }

}
