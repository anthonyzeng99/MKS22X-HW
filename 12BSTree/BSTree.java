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
	    return height(root, 1);
	}

	public int height(Node current, int h) {
	    if (current.right != null && current.left != null) {
		return Math.max( height(current.left, h + 1), height(current.right, h + 1));
	    } else if (current.left != null) {
		return height(current.left, h + 1);
	    } else if (current.right != null) {
		return height(current.right, h + 1);
	    }
	    return h;
	}

	public void add(T value) {
	    add(root,value);
	}

	private void add(Node current, T value) {
	    if ( value.compareTo(current.data) < 0 ) {
		if (current.left == null ) {
		    current.left = new Node(value);
		} else { 
		    add(current.left,value);
		}		    
	    } else if ( value.compareTo(current.data) > 0 ) {
		if (current.right == null) {
		    current.right = new Node(value);
		} else {
		    add(current.right,value);
		}
	    }	
	}

	
	
	public String toString() {
	    return toString(root);
	}

	public String toString(Node current) {
	    if (current.left != null && current.right != null) {
		return current.data + " " + toString(current.left) + " " + toString(current.right);
	    } else if (current.left != null) {
		return current.data + " " + toString(current.left) + " _";
	    } else if (current.right != null) {
		return current.data + " " + toString(current.right) + " _ ";
	    } 
	    return current.data + " _ _";
	}
	
	public boolean contains(T value) {
	    return contains(value, root);
	}

	private boolean contains(T value, Node current) {
       	    if (current.data.compareTo(value) == 0) {
		return true;
	    } 

	    if ( value.compareTo(current.data) < 0 ) {
		if (current.left == null) {
		    return false;
		} else {
		    System.out.println("<");
		    return contains(value, current.left);
		}
	    } else if (value.compareTo(current.data) > 0) {
		if (current.right == null) {
		    return false;
		} else {
		    System.out.println(">");
		    return contains(value, current.right);
		}
	    }
	    System.out.println("*");
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
	    //tree.add(26);
	    //tree.add(13);
	    //tree.add(18);
	    //tree.add(62);
	    tree.add(85);
	    System.out.println(tree.getHeight());
	}
	
    }
