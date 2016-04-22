import java.util.*;

public class BSTree<T extends Comparable<T>> {
    private Node root;

    public BSTree() {
	root = null;
    }
    
    public int  height() {
	if (root == null) {
	    return 0;
	}
	return root.height();
    }

    public void add(T value) {
	if (root == null) {
	    root = new Node(value);
	}
	else {
	    root.add(value);
	}
    }

    public String toString() {
	if (root == null) {
	    return "";
	}
	return root.toString();
    }

    public boolean contains(T value) {
	if (root == null) {
	    return false;
	}
	return root.contains(value);
    }

    public boolean remove(T value) {
	if (!root.contains(value)) {
	    throw new NoSuchElementException();
	}
	return false;
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
	public void setLeft(Node left) {
	    this.left = left;
	}
	public void setRight(Node right) {
	    this.right = right;
	}

	public void add(T value) {
	    if (data.compareTo(value) > 0) {
		if (left == null) {
		    left = new Node(value);
		}
		else {
		    left.add(value);
		}
	    }
	    else {
		if (right == null) {
		    right = new Node(value);
		}
		else {
		    right.add(value);
		}
	    }
	}

	public int height() {
	    if (left == null && right == null) {
		return 1;
	    }
	    else if (left == null && right != null) {
		return 1 + right.height();
	    }
	    else if (right == null && left != null) {
		return 1 + left.height();
	    }
	    return 1 + Math.max(left.height(), right.height());
	}

	public String toString() {
	    String ret = "" + data + " ";
	    if (left == null) {
		ret += "_ ";
	    }
	    else {
		ret += left.toString();
	    }
	    if (right == null) {
		ret += "_ ";
	    }
	    else {
		ret += right.toString();
	    }
	    return ret;
	}

	public boolean contains(T value) {
	    if (data.equals(value)) {
		return true;
	    }
	    else {
		if (left == null && right == null) {
		    return false;
		}
		else if (left != null && right == null) {
		    return left.contains(value);
		}
		else if (left == null && right != null) {
		    return right.contains(value);
		}
		else {
		    return left.contains(value) || right.contains(value);
		}
	    }
	}

	public boolean remove(T value) {
	    return false;
	}
    }
    public static void main(String[] args) {
	BSTree<String> t = new BSTree<String>();
	System.out.println("Start");
	t.add("d");
	t.add("b");
	t.add("a");
	t.add("c");
	t.add("f");
	t.add("e");
	t.add("g");
	System.out.println(t);

	System.out.println("Contains q: " + t.contains("q"));
	System.out.println("Contains g: " + t.contains("g"));
    }
}
