public class BSTree<T extends Comparable<T>> {

    private class Node {
	T data;
	Node left;
	Node Right;

	private Node(T data) {
	    this.data = data;
	}

	private int height() {
	    return 0;
	}

	private void add(T value) {

	}

	private String toString() {
	    return "";
	}

	private boolean contains(T value) {
	    return false;
	}

    }

    private Node root;

    public void add(T value) {}

    public String toString() {}

    public boolean contains(T value) {}

    public int getHeight() {}

}
