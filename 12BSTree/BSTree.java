public class BSTree<T extends Comparable<T>> {
    private Node root;

    public BSTree(Node root) {
	this.root = root;
    }
    
    public Node getRoot() {
	return root;
    }

    private class Node {
	private T data;
	private Node left, right;

	public Node(T data) {
	    this.data = data;
	}

	public T getData() {
	    return data;
	}
	public void setData(T data) {
	    this.data = data;
	}

	public Node getLeft() {
	    return left;
	}
	public Node getRight() {
	    return right;
	}
	public Node setLeft(Node left) {
	    this.left = left;
	}
	public Node setRight(Node right) {
	    this.right = right;
	}

	public void add(T value) {
	    Node current = this;
	    while (!(current.getLeft() == null && current.getRight() == null) || //fix
	}
    }
}
